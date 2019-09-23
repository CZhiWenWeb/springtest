package com.czw.browser.data.service;

import com.czw.browser.data.model.UserDto;
import com.czw.browser.data.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-09-07 11:50
 * @UpdeteTime: 2019-09-07 11:50
 * @Description:
 */

/**
 * @configuration与@compoent的区别：
 * @Configuration注解一般注解在这样的类上：这个类里面有@Value注解的成员变量和@Bean注解的方法，就是一个配置类
 * @configuration是单例的，
 * @Component注解的范围最广，所有类都可以注解，@component多例的
 */
@Slf4j
@Configuration
public class MyUserDetailService implements UserDetailsService {
	private UserService userService;

	//构造注入，防止userService为null
	@Autowired
	public MyUserDetailService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Spring Security自动将我们的实现类注入到DaoAuthenticationProvider中
	 *
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user;
		if (StringUtils.endsWithIgnoreCase(username, "_phone")) {
			String phone = username.substring(0, username.length() - 6);
			log.info("根据手机号：" + phone + "查询用户");
			user = userService.selectByExample("phone", phone).get(0);

		} else {
			log.info("根据昵称" + username + "查询用户");
			user = userService.selectByExample("username", username).get(0);
		}
		//查询权限
		List<String> authList = userService.selectPermissionByUserId(user.getId());
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		authList.stream().forEach
				//遍历authList，使用匿名内部类新建grantedAuthority的实例,并添加到list
						((author) -> authorities.add(() -> author));
		UserDto userDto = new UserDto(user);
		userDto.setListAuthorities(authorities);
		return userDto;
	}
}
