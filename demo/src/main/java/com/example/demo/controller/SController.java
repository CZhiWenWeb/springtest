package com.example.demo.controller;

import com.example.demo.common.MyResponse;
import com.example.demo.properties.SecurityProperties;
import com.example.demo.validate.abstracts.CaptchaProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: czw
 * @CreateTime: 2019-09-03 14:26
 * @UpdeteTime: 2019-09-03 14:26
 * @Description:
 */
@Controller
@Slf4j
public class SController {
	//重定向策略
	private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
	//把当前请求缓存到session里去
	private RequestCache requestCache=new HttpSessionRequestCache();
	//注入security属性配置
	@Autowired
	private SecurityProperties securityProperties;

	@GetMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//拿不到缓存
		//requestCache.saveRequest(request,response);
		SavedRequest savedRequest=requestCache.getRequest(request,response);
		if (savedRequest!=null){
			String targetUrl=savedRequest.getRedirectUrl();
			log.info("引发跳转的请求是："+targetUrl);
			//if (StringUtils.endsWithIgnoreCase(targetUrl,".html")){
			//	redirectStrategy.sendRedirect(request,response,redirectUrl);
			//}
			//String redirectUrl=securityProperties.getBrowser().getLoginPage();
			//redirectStrategy.sendRedirect(request,response,redirectUrl);
		}
		return "login";
	}

	@RequestMapping("/")
	public String root(HttpServletResponse response,HttpServletRequest request) {
		return "index";
	}
	@GetMapping("/out")
	public String out(){
		return "loginout";
	}

	@Autowired
	private Map<String, CaptchaProcessor> captchaProcessorMap;


	//图形验证码
	//短信验证码
	@GetMapping("/captcha")
	public void createCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		captchaProcessorMap.get( "imageCaptchaProcessor").process("",new ServletWebRequest(request,response));
	}
	@GetMapping("/image")
	public String get(){
		return "image";
	}
	@GetMapping("/go")
	public String go(){
		return "user/go";
	}
	@PostMapping("/selectMessageForLogin")
	public MyResponse selectUserNameAndPsByCookie(HttpServletRequest request,HttpServletResponse response){
		return null;
	}
}
