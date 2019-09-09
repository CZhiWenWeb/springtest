package com.example.demo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 10:12
 * @UpdeteTime: 2019-09-04 10:12
 * @Description:
 */@Component
@Slf4j
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
	                                    HttpServletResponse response,
	                                    Authentication authentication) throws IOException, ServletException {
		System.out.println("登入成功");
		String username=authentication.getName();
		log.info("creating new persistent login for me:"+username);
		//重定向
		//PersistentRememberMeToken persistentToken=new PersistentRememberMeToken(username,gen)
		super.onAuthenticationSuccess(request,response,authentication);
	}
}
