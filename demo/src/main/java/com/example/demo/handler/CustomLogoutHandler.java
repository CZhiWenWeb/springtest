package com.example.demo.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: czw
 * @CreateTime: 2019-09-07 09:49
 * @UpdeteTime: 2019-09-07 09:49
 * @Description:
 */
@Component
public class CustomLogoutHandler implements LogoutHandler {
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

	}
}
