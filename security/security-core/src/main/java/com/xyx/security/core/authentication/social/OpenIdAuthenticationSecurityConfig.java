package com.xyx.security.core.authentication.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 15:19
 * @UpdeteTime: 2019-08-31 15:19
 * @Description:
 */
@Component
public class OpenIdAuthenticationSecurityConfig
extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
	@Autowired
	private AuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler customAuthenticationFailHandler;

	@Autowired
	private SocialUserDetailsService socialUserDetailsService;

	@Autowired
	private UsersConnectionRepository usersConnectionRepository;

	@Override
	public void configure(HttpSecurity http)throws Exception{
	//	过滤器
		OpenIdAuthenticationFilter openIdAuthenticationFilter=new OpenIdAuthenticationFilter();
	//	将AuthenticationManager注入给过滤器
		openIdAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
		//指定其验证成功和验证失败handler
		openIdAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
		openIdAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailHandler);

		//身份验证提供者
		OpenIdAuthenticationProvider openIdAuthenticationProvider = new OpenIdAuthenticationProvider();
		//设置socialUserDetailsService
		openIdAuthenticationProvider.setUserDetailsService(socialUserDetailsService);
		//设置UsersConnectionRepository
		openIdAuthenticationProvider.setUsersConnectionRepository(usersConnectionRepository);
		//加入配置
		http.authenticationProvider(openIdAuthenticationProvider)
				//将该过滤器加到UsernamePasswordAuthenticationFilter过滤器后边
				.addFilterAfter(openIdAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
