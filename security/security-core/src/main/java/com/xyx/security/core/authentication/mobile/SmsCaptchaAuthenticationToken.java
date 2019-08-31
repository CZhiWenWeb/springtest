package com.xyx.security.core.authentication.mobile;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 09:39
 * @UpdeteTime: 2019-08-31 09:39
 * @Description:短信验证码身份验证token
 * 该类在认证成功前，放手机号，成功后，放登入信息
 * AbstractAuthentication：authorities字段存放权限集合，details存放请求信息，authenticated存放是否通过验证
 */
public class SmsCaptchaAuthenticationToken extends AbstractAuthenticationToken {
	private static final long serialVersionUID= SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	//在认证成功前，放手机号，成功后，放登入信息
	private final Object principal;

	/**
	 * 未登入时该类构造函数
	 * @param phone
	 */
	public SmsCaptchaAuthenticationToken(String phone){
		super(null);
		this.principal=phone;
		//未通过校验
		setAuthenticated(false);
	}
	//登入后principal存放用户信息
	public SmsCaptchaAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities){
		//拥有的权限集合
		super(authorities);
		this.principal=principal;
		//重写时，必须使用super的方法，通过验证
		super.setAuthenticated(true);
	}
	//获取权限
	@Override
	public Object getCredentials() {
		//return this.getAuthorities();
		return null;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}
	//权限擦除
	@Override
	public void eraseCredentials(){
		super.eraseCredentials();
	}
}
