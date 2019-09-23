package com.czw.browser.config;

import com.czw.browser.data.service.MyUserDetailService;
import com.czw.code.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.sql.DataSource;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 15:11
 * @UpdeteTime: 2019-09-23 15:11
 * @Description:
 */
@Slf4j
@Configuration
@Order(1)
//创建认证服务器
@EnableAuthorizationServer
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private SecurityProperties properties;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private MyUserDetailService userDetailService;

	@Bean
	public PasswordEncoder get() {
		return new MyPasswordEncoder();
	}

	//	注册authenticationManager Bean
	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManagerBean();
	}

	//通过重载，配置拦截器如何保护请求
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatchers()
				.antMatchers("/login")
				.antMatchers("/oauth/authorize")
				.and()
				.authorizeRequests()
				.antMatchers("/captcha/**",
						properties.getBrowser().getLoginPage(),
						properties.getBrowser().getLoginProcessUrl(),
						properties.getBrowser().getSigUpUrl())
				.authenticated()
				.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/user/login").permitAll()
				.and().csrf().disable();


	}

	//通过重载，配置spring security的filter链
	public void configure(WebSecurity security) {

	}

	//通过重载，配置user-detail服务
	@Override
	public void configure(AuthenticationManagerBuilder builder) {
		try {
			log.info("构建AuthenticationManagerBuilder");
			builder.jdbcAuthentication().dataSource(dataSource);
			builder.userDetailsService(userDetailService);
		} catch (Exception e) {
			log.info("构建AuthenticationManagerBuilder失败：" + e.getMessage());
			e.printStackTrace();
		}
	}

	private class MyPasswordEncoder implements PasswordEncoder {

		@Override
		public String encode(CharSequence rawPassword) {
			return rawPassword.toString();
		}

		@Override
		public boolean matches(CharSequence rawPassword, String encodedPassword) {
			return encodedPassword.equals(rawPassword);
		}
	}
}
