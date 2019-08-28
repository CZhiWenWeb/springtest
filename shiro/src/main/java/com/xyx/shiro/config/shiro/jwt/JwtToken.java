package com.xyx.shiro.config.shiro.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author: czw
 * @CreateTime: 2019-08-26 14:58
 * @UpdeteTime: 2019-08-26 14:58
 * @Description:JwtToken
 */
public class JwtToken implements AuthenticationToken {
	private String token;
	public JwtToken(String token){
		this.token=token;
	}
	@Override
	public Object getPrincipal() {
		return token;
	}

	@Override
	public Object getCredentials() {
		return token;
	}
}
