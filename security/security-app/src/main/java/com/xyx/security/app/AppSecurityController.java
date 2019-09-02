package com.xyx.security.app;

import com.xyx.security.core.support.SocialUserInfo;
import com.xyx.security.social.AppSignUpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: czw
 * @CreateTime: 2019-09-02 14:07
 * @UpdeteTime: 2019-09-02 14:07
 * @Description:处理app的注册逻辑
 */
@RestController
public class AppSecurityController {
	/**
	 * 自定义的用来在redis中存储社交账号信息和在关联表中增加记录的工具类
	 */
	@Autowired
	private AppSignUpUtils appSignUpUtils;
	/**
	 * 框架自带的工具类,需要session支持.
	 * 当社交登录成功后,social框架源码中,已经将用户信息存入了session中.
	 * 然后转发到了我们这个请求.都是内部跳转.
	 * 所以此时仍旧可以从session中获取到社交用户信息
	 */
	@Autowired
	private ProviderSignInUtils providerSignInUtils;

	/**
	 当app模块中.用户社交登录成功后.但该社交帐号并未绑定到自己业务系统中的任意帐号,
	 则跳转到该注册路径.
	 返回社交登录成功的社交帐号信息,让app展示,并引导用户注册.
	 * @param request
	 * @return
	 */
	@GetMapping("/social/signUp")
	public SocialUserInfo getSocialUserInfo(HttpServletRequest request){
		SocialUserInfo userInfo=new SocialUserInfo();
	//	从session中获取第三方用户信息
		Connection<?> connection=providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
		//将该用户信息存入redis，否则下次app访问不携带cookie，则session失效，无法再次获取到用户信息
		appSignUpUtils.saveConnetionData(new ServletWebRequest(request),connection.createData());
		return userInfo.setProviderId(connection.getKey().getProviderId())
				.setProviderUserId(connection.getKey().getProviderUserId())
				.setNickname(connection.getDisplayName())
				.setHeadimg(connection.getImageUrl());
	}
}
