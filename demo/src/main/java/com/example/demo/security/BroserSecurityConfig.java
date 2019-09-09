package com.example.demo.security;

import com.example.demo.handler.CustomAuthenticationFailHandler;
import com.example.demo.handler.CustomAuthenticationSuccessHandler;
import com.example.demo.handler.CustomLogoutSuccessHandler;
import com.example.demo.properties.SecurityProperties;
import com.example.demo.service.MyUserDetailService;
import com.example.demo.validate.CaptchaFiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: czw
 * @CreateTime: 2019-09-03 13:58
 * @UpdeteTime: 2019-09-03 13:58
 * @Description:
 */
@Configuration
public class BroserSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	MyUserDetailService userDetailService;
	@Autowired
	DataSource dataSource;
	@Autowired
	CaptchaFiler captchaFiler;
	@Autowired
	SecurityProperties securityProperties;
	@Autowired
	private CustomAuthenticationSuccessHandler customSuccessHandler;
	@Autowired
	private CustomAuthenticationFailHandler customFailHandler;
	@Autowired
	private CustomLogoutSuccessHandler customLogoutSuccessHandler;
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		String redirectUrl=securityProperties.getBrowser().getLoginPage();
		//"/login"为访问login.html的路径controller使用get请求进行跳转
		http.addFilterBefore(captchaFiler, UsernamePasswordAuthenticationFilter.class)
				.formLogin().loginPage("/login")
				//loginProcessingUrl与表单action对应，无需controller处理
				.loginProcessingUrl("/user/login")
				.permitAll().successHandler(customSuccessHandler).failureHandler(customFailHandler)
				.and()
	//			请求授权
				.authorizeRequests()
	//			不需要权限认证的url
				.antMatchers("/out","/loginout","/static/**","/css/**","/img/**","/js/**","/captcha","/login",redirectUrl).permitAll()
				.anyRequest().authenticated()
				.and().logout()
				//logoutSuccessUrl对应跳转url,logoutUrl为页面url
				.logoutSuccessUrl("/out").logoutUrl("/loginout").deleteCookies("JSESSIONID").permitAll()
				.and()
				.rememberMe().tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
				.userDetailsService(userDetailService)
				.and()
				.csrf().disable();
	}
	private class MyPasswordEncoder implements PasswordEncoder{

		@Override
		public String encode(CharSequence rawPassword) {
			return rawPassword.toString();
		}

		@Override
		public boolean matches(CharSequence rawPassword, String encodedPassword) {
			return encodedPassword.equals(rawPassword);
		}
	}
	@Bean
	public PasswordEncoder get(){
		return new MyPasswordEncoder();
	}
	@Bean
	public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler(){
		return new SavedRequestAwareAuthenticationSuccessHandler(){
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			                                    Authentication authentication) throws ServletException, IOException {
				User user= (User) authentication.getPrincipal();
				logger.info(user.getUsername()+"success");
				//登入成功后跳转页面
				super.onAuthenticationSuccess(request,response,authentication);
			}
		};
	}
	//记住我的功能
	@Bean
	public PersistentTokenRepository persistentTokenRepository(){
		JdbcTokenRepositoryImpl tokenRepository=new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		//第一次启动开启，后续关闭
		//tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}
}
