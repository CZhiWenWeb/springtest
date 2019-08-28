package com.xyx.shiro.config.shiro;

import com.xyx.shiro.config.shiro.jwt.JwtToken;
import com.xyx.shiro.mapper.PermissionMapper;
import com.xyx.shiro.mapper.RoleMapper;
import com.xyx.shiro.mapper.UserMapper;
import com.xyx.shiro.model.PermissionDto;
import com.xyx.shiro.model.RoleDto;
import com.xyx.shiro.model.UserDto;
import com.xyx.shiro.model.common.Constant;
import com.xyx.shiro.util.JedisUtil;
import com.xyx.shiro.util.JwtUtil;
import com.xyx.shiro.util.common.StringUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-08-26 15:21
 * @UpdeteTime: 2019-08-26 15:21
 * @Description:
 */

/**
 * 构造器注入，1.在实例化之后依赖不可变，2.可以保证依赖不为空，3.避免了循环依赖
 */
@Service
public class UserRealm extends AuthorizingRealm {
	private final UserMapper userMapper;
	private final RoleMapper roleMapper;
	private final PermissionMapper permissionMapper;

	@Autowired
	public UserRealm(UserMapper userMapper, RoleMapper roleMapper, PermissionMapper permissionMapper) {
		this.userMapper = userMapper;
		this.roleMapper = roleMapper;
		this.permissionMapper = permissionMapper;
	}

	/**
	 * 必须重写此方法，不然shiro会报错
	 *
	 * @param authenticationToken
	 * @return
	 */
	@Override
	public boolean supports(AuthenticationToken authenticationToken) {
		return authenticationToken instanceof JwtToken;
	}

	/**
	 * 授权模块
	 *
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		String account = JwtUtil.getClaim(principalCollection.toString(), Constant.ACCOUNT);
		UserDto userDto = new UserDto();
		userDto.setAccount(account);
		//查询用户角色
		List<RoleDto> roleDtos = roleMapper.findRoleByUser(userDto);
		for (RoleDto roleDto : roleDtos
		) {
			if (roleDto != null) {
				//添加角色
				simpleAuthorizationInfo.addRole(roleDto.getName());
				//	根据用户角色查询权限
				List<PermissionDto> permissionDtos = permissionMapper.findPermissionByRole(roleDto);
				for (PermissionDto p : permissionDtos
				) {
					if (p != null) {
						//	添加权限
						simpleAuthorizationInfo.addStringPermission(p.getPerCode());
					}
				}
			}
		}
		return simpleAuthorizationInfo;
	}

	/**
	 * 用户认证
	 *
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String token = (String) authenticationToken.getCredentials();
		//解密获得account,用于和数据库进行对比
		String account = JwtUtil.getClaim(token, Constant.ACCOUNT);
		//账号为空
		if (StringUtil.isBlank(account)) {
			throw new AuthenticationException("Token中账号为空");
		}
		//查询用户是否存在
		UserDto userDto = new UserDto();
		userDto.setAccount(account);
		userDto = userMapper.selectOne(userDto);
		if (userDto == null) {
			throw new AuthenticationException("该账号不存在");
		}
		//开始认证，要accessToken认证通过，且Redis中存在refreshToken,且两个Token时间戳一致
		if (JwtUtil.verify(token) && JedisUtil.exists(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account)) {
			//	获取RefreshToken的时间戳
			String currentTimeMillsRedis = JedisUtil.getObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account).toString();
			//	获取AccessToken时间戳,与RefreshToken的时间戳对比
			if (JwtUtil.getClaim(token, Constant.CURRENT_TIME_MILLIS).equals(currentTimeMillsRedis)) {
				return new SimpleAuthenticationInfo(token, token, "userRealm");
			}
		}
		throw new AuthenticationException("Token已过期");
	}
}
