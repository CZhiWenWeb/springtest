package com.czw.ms.monitor.admin.configure;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * @Author: czw
 * @CreateTime: 2019-10-15 16:57
 * @UpdeteTime: 2019-10-15 16:57
 * @Description:
 */
@EnableWebSecurity
public class MsSecurityConfigure extends WebSecurityConfigurerAdapter {
	private final String adminContextPath;

	public MsSecurityConfigure(AdminServerProperties adminServerProperties){
		this.adminContextPath=adminServerProperties.getContextPath();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		SavedRequestAwareAuthenticationSuccessHandler successHandler=new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setTargetUrlParameter("redirectTo");

		http.authorizeRequests()
				.antMatchers(adminContextPath+"/assets/**").permitAll()
				.antMatchers(adminContextPath+"/login").permitAll()
				.anyRequest().authenticated()
		.and()
		.formLogin().loginPage(adminContextPath+"/login").successHandler(successHandler)
		.and().logout().logoutUrl(adminContextPath+"/logout").and()
		.httpBasic().and().csrf().disable();
	}
}
