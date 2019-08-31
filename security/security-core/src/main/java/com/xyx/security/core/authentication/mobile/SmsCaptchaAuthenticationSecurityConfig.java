package com.xyx.security.core.authentication.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 10:56
 * @UpdeteTime: 2019-08-31 10:56
 * @Description:短信验证码登入配置，该配置在app和browser中通用，所以写在core中
 */
@Component
public class SmsCaptchaAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
	private AuthenticationSuccessHandler customAuthenticationSuccessHandler;
	private AuthenticationFailureHandler customAuthenticationFailHandler;
	private UserDetailsService customUserDetailsService;
	@Autowired
	public SmsCaptchaAuthenticationSecurityConfig(AuthenticationFailureHandler customAuthenticationFailHandler,
	                                              AuthenticationSuccessHandler customAuthenticationSuccessHandler,
	                                              UserDetailsService customUserDetailsService){
		this.customAuthenticationFailHandler=customAuthenticationFailHandler;
		this.customAuthenticationSuccessHandler=customAuthenticationSuccessHandler;
		this.customUserDetailsService=customUserDetailsService;
	}
	@Override
	public void configure(HttpSecurity http) throws Exception{
	//	过滤器
		SmsCaptchaAuthenticationFilter smsCaptchaAuthenticationFilter=new SmsCaptchaAuthenticationFilter();
	//	将authenticationManager注入给过滤器
		smsCaptchaAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
	//	指定其验证成功和验证失败handler
		smsCaptchaAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
		smsCaptchaAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailHandler);
	//	身份验证提供者
		SmsCaptchaAuthenticationProvider smsCaptchaAuthenticationProvider=new SmsCaptchaAuthenticationProvider();
	//	设置userDetailsService
		smsCaptchaAuthenticationProvider.setUserDetailsService(customUserDetailsService);
	//	加入配置
		http.authenticationProvider(smsCaptchaAuthenticationProvider)
	//			将该过滤器加到UsernamePasswordAuthenticationFilter过滤器后边
		.addFilterAfter(smsCaptchaAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
