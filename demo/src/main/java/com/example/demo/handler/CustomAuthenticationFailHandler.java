package com.example.demo.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 10:09
 * @UpdeteTime: 2019-09-04 10:09
 * @Description:
 */
@Component
public class CustomAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
	public CustomAuthenticationFailHandler(){
		this.setDefaultFailureUrl("/login?error=true");
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException{
		super.onAuthenticationFailure(request,response,e);
		System.out.println("登入失败");
	}
}
