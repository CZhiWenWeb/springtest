package com.xyx.security.core.authentication.mobile;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 09:13
 * @UpdeteTime: 2019-08-31 09:13
 * @Description:短信身份过滤器
 */
public class SmsCaptchaAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	public static final String FORM_PHONE_KEY="phone";
	private String phoneParameter=FORM_PHONE_KEY;
	//是否只处理post请求
	private boolean postOnly=true;
	//构造方法
	public SmsCaptchaAuthenticationFilter(){
		//该类用来处理那个请求,AntPathRequestMatcher可以使用三种通配符
		//?匹配任意一个字符 *匹配任意多个字符，但不能跨越目录，**可以跨越目录
		super(new AntPathRequestMatcher("/login/phone","POST"));
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
		//请求方法是否为post
		if (postOnly&&!request.getMethod().equals("POST")){
			throw new AuthenticationServiceException(
					"Authentication method not supported"+request.getMethod());
		}
		//获取手机号
		String phone=obtainPhone(request);
		if (phone==null){
			phone="";
		}
		phone=phone.trim();
		//调用认证前的构造方法实例化一个AuthenticationToken
		SmsCaptchaAuthenticationToken authRuest=new SmsCaptchaAuthenticationToken(phone);
		//将请求放入SmsCaptchaAuthenticationToken
		setDetails(request,authRuest);
		//验证SmsCaptchaAuthenticationToken
		return this.getAuthenticationManager().authenticate(authRuest);
	}

	/**
	 * 获取手机号
	 * @param request
	 * @return
	 */
	public String obtainPhone(HttpServletRequest request){
		return request.getParameter(phoneParameter);
	}

	/**
	 * 将请求的详细信息放入SmsCaptchaAuthenticationToken
	 * @param request
	 * @param authRequest
	 */
	public void setDetails(HttpServletRequest request,SmsCaptchaAuthenticationToken authRequest){
		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
	}

	/**
	 * 设置手机号
	 * @param phoneParameter
	 */
	public void setPhoneParameter(String phoneParameter){
		Assert.hasText(phoneParameter,"Username parameter must not be empty or null");
		this.phoneParameter=phoneParameter;
	}

	/**
	 * 设置是否只处理post请求
	 * @param postOnly
	 */
	public void setPostOnly(boolean postOnly){
		this.postOnly=postOnly;
	}

	/**
	 * 获取手机号
	 * @return
	 */
	public final String getPhoneParameter(){
		return phoneParameter;
	}
}
