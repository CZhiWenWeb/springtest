package com.xyx.shiro.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyx.shiro.exception.CustomException;
import com.xyx.shiro.model.UserDto;
import com.xyx.shiro.model.common.BaseDto;
import com.xyx.shiro.model.common.Constant;
import com.xyx.shiro.model.common.ResponseBean;
import com.xyx.shiro.model.vaild.group.UserEditValidGroup;
import com.xyx.shiro.model.vaild.group.UserLoginValidGroup;
import com.xyx.shiro.service.UserService;
import com.xyx.shiro.util.AesCipherUtil;
import com.xyx.shiro.util.JedisUtil;
import com.xyx.shiro.util.JwtUtil;
import com.xyx.shiro.util.UserUtil;
import com.xyx.shiro.util.common.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @Author: czw
 * @CreateTime: 2019-08-27 11:43
 * @UpdeteTime: 2019-08-27 11:43
 * @Description:UserController
 */
@RestController
@RequestMapping("/user")
@PropertySource("classpath:config.properties")
public class UserController {
	/**
	 * RefreshToken过期时间
	 */
	@Value("${refreshTokenExpireTime}")
	private String refreshTokenExpireTime;

	private final UserUtil userUtil;
	private final UserService userService;

	@Autowired
	public UserController(UserService userService,UserUtil userUtil) {
		this.userService = userService;
		this.userUtil=userUtil;
	}

	/**
	 * 获取用户列表
	 *
	 * @param baseDto
	 * @return
	 */
	@GetMapping
	/**
	 * logical.and表示value的权限都需要，logical.or表示只要其中一个
	 */
	@RequiresPermissions(logical = Logical.AND, value = {"user:view"})
	public ResponseBean user(@Validated BaseDto baseDto) {
		PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
		List<UserDto> userDtos = userService.selectAll();
		PageInfo<UserDto> selectPage = new PageInfo<>(userDtos);
		if (userDtos == null || userDtos.size() <= 0) {
			throw new CustomException("查询失败");
		}
		Map<String, Object> result = new HashMap<>();
		result.put("count", selectPage.getTotal());
		result.put("data", selectPage.getList());
		return new ResponseBean(HttpStatus.OK.value(), "查询成功", result);
	}

	/**
	 * 登入授权
	 * @param userDto
	 * @param response
	 * @return
	 */
	@PostMapping("/login")
	public ResponseBean login(@Validated(UserLoginValidGroup.class) @RequestBody(required = false) UserDto userDto, HttpServletResponse response){
	//	查询数据库中的账号信息
		UserDto userDtoTemp=new UserDto();
		userDtoTemp.setAccount(userDto.getAccount());
		userDtoTemp=userService.selectOne(userDtoTemp);
		if (userDtoTemp==null){
			throw new CustomException("该账号不存在");
		}
	//	密码进行AES解密
		String key= AesCipherUtil.deCrypto(userDtoTemp.getPassword());
		// 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
		if (key.equals(userDto.getAccount()+userDto.getPassword())){
		//	清除可能存在的shiro权限信息缓存
			if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE+userDto.getAccount())){
				JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE+userDto.getAccount());
			}
		//	设置RefreshToken
			String currentTimeMills=String.valueOf(System.currentTimeMillis());
			JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN+userDto.getAccount(),currentTimeMills,Integer.parseInt(refreshTokenExpireTime));
// 从Header中Authorization返回AccessToken，时间戳为当前时间戳
			String token = JwtUtil.sign(userDto.getAccount(), currentTimeMills);
			response.setHeader("Authorization", token);
			response.setHeader("Access-Control-Expose-Headers", "Authorization");
			return new ResponseBean(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
		}else {
			throw new CustomException("账号或密码错误");
		}
	}

	/**
	 * 测试登入
	 * @return
	 */
	@GetMapping("/article")
	public ResponseBean article() {
		Subject subject = SecurityUtils.getSubject();
		// 登录了返回true
		if (subject.isAuthenticated()) {
			return new ResponseBean(HttpStatus.OK.value(), "您已经登录了(You are already logged in)", null);
		} else {
			return new ResponseBean(HttpStatus.OK.value(), "你是游客(You are guest)", null);
		}
	}

	@GetMapping("/info")
	@RequiresAuthentication
	public ResponseBean info() {
		// 获取当前登录用户
		UserDto userDto = userUtil.getUser();
		// 获取当前登录用户Id
		Integer id = userUtil.getUserId();
		// 获取当前登录用户Token
		String token = userUtil.getToken();
		// 获取当前登录用户Account
		String account = userUtil.getAccount();
		return new ResponseBean(HttpStatus.OK.value(), "您已经登录了(You are already logged in)", userDto);
	}

	/**
	 * 获取在线人数
	 * @return
	 */
	@GetMapping("/online")
	@RequiresPermissions(logical = Logical.AND, value = {"user:view"})
	public ResponseBean online() {
		List<Object> userDtos = new ArrayList<Object>();
		// 查询所有Redis键
		Set<String> keys = JedisUtil.keysS(Constant.PREFIX_SHIRO_REFRESH_TOKEN + "*");
		for (String key : keys) {
			if (JedisUtil.exists(key)) {
				// 根据:分割key，获取最后一个字符(帐号)
				String[] strArray = key.split(":");
				UserDto userDto = new UserDto();
				userDto.setAccount(strArray[strArray.length - 1]);
				userDto = userService.selectOne(userDto);
				//long转localDateTime
				LocalDateTime dateTime=LocalDateTime.ofInstant((new Date(Long.parseLong(JedisUtil.getObject(key).toString()))).toInstant(), ZoneId.of("Asia/Shanghai"));
				// 设置登录时间
				userDto.setLoginTime(dateTime);
				userDtos.add(userDto);
			}
		}
		if (userDtos == null || userDtos.size() <= 0) {
			throw new CustomException("查询失败(Query Failure)");
		}
		return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", userDtos);
	}

	/**
	 * 新增用户
	 * @param userDto
	 * @return
	 */
	@PostMapping
	@RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
	public ResponseBean add(@Validated(UserEditValidGroup.class) @RequestBody UserDto userDto) {
		// 判断当前帐号是否存在
		UserDto userDtoTemp = new UserDto();
		userDtoTemp.setAccount(userDto.getAccount());
		userDtoTemp = userService.selectOne(userDtoTemp);
		if (userDtoTemp != null && !StringUtil.isBlank(userDtoTemp.getPassword())) {
			throw new CustomException("该帐号已存在(Account exist.)");
		}
		userDto.setRegTime(new Date());
		// 密码以帐号+密码的形式进行AES加密
		if (userDto.getPassword().length() > Constant.PASSWORD_MAX_LEN) {
			throw new CustomException("密码最多8位(Password up to 8 bits.)");
		}
		String key = AesCipherUtil.enCrypto(userDto.getAccount() + userDto.getPassword());
		userDto.setPassword(key);
		int count = userService.insertSelective(userDto);
		if (count <= 0) {
			throw new CustomException("新增失败(Insert Failure)");
		}
		return new ResponseBean(HttpStatus.OK.value(), "新增成功(Insert Success)", userDto);
	}

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	@RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
	public ResponseBean delete(@PathVariable("id") Integer id) {
		int count = userService.deleteByPrimaryKey(id);
		if (count <= 0) {
			throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
		}
		return new ResponseBean(HttpStatus.OK.value(), "删除成功(Delete Success)", null);
	}
}
