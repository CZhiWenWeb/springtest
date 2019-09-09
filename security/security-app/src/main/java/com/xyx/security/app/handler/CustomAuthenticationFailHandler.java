package com.xyx.security.app.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyx.security.core.properties.LoginType;
import com.xyx.security.core.properties.SecurityProperties;
import com.xyx.security.core.support.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: czw
 * @CreateTime: 2019-09-02 13:33
 * @UpdeteTime: 2019-09-02 13:33
 * @Description:自定义身份失败处理器
 */
@Component("customAuthenticationFailHandler")
@Slf4j
public class CustomAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,HttpServletResponse response, AuthenticationException e)throws IOException, ServletException {
		log.info("登入失败");
		//如果配置的的登录方式是json,使用自定义处理器
		if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
			//状态码500
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			//将authentication对象转为jsonString,返回
//            response.getWriter().write(objectMapper.writeValueAsString(e));
			response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(e.getMessage())));
		}else{
			//否则使用父类处理方法,重定向
			super.onAuthenticationFailure(request,response,e);
		}
	}
}
