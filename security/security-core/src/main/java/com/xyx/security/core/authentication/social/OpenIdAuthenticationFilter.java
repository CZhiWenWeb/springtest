package com.xyx.security.core.authentication.social;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 15:03
 * @UpdeteTime: 2019-08-31 15:03
 * @Description:社交登入 身份验证过滤器
 */
public class OpenIdAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	//请求中openId和providerId的key
	public static final String FORM_OPEN_ID_KEY="openId";
	public static final String FORM_PROVIDER_ID_KEY="providerId";
	//是否只处理post
	private boolean postOnly=true;

	public OpenIdAuthenticationFilter(){
	//	该类用来处理哪个路径
		super(new AntPathRequestMatcher("/authentication/openId","POST"));
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
		if (postOnly&&!request.getMethod().equals("POST")){
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}

		//获取openId,如果为空,就用""
		String openId = ServletRequestUtils.getStringParameter(request, FORM_OPEN_ID_KEY, "").trim();
		//获取providerId
		String providerId = ServletRequestUtils.getStringParameter(request, FORM_PROVIDER_ID_KEY, "").trim();

		//构建还未认证的 token存储
		OpenIdAuthenticationToken authRequest = new OpenIdAuthenticationToken(openId, providerId);

		setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}

	/**
	 * 将请求的详细信息,放入OpenIdAuthenticationToken
	 */
	protected void setDetails(HttpServletRequest request,
	                          OpenIdAuthenticationToken authRequest) {
		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
	}



	/**
	 * set
	 */
	public void setPostOnly(boolean postOnly) {
		this.postOnly = postOnly;
	}
}
