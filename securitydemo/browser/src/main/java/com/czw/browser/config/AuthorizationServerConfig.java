package com.czw.browser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 15:26
 * @UpdeteTime: 2019-09-23 15:26
 * @Description:授权服务配置
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private TokenStore redisTokenStore;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService)
				//		指定令牌存储方式
				.tokenStore(redisTokenStore)
				//使用jwt替换默认的令牌
				.accessTokenConverter(jwtAccessTokenConverter)
		;
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("demoClient1")
				.secret(passwordEncoder.encode("123456"))
				.accessTokenValiditySeconds(3600)
				.refreshTokenValiditySeconds(864000)
				.scopes("all")
				.authorizedGrantTypes("password", "refresh_token")

				.and()
				.withClient("demo2")
				.secret(passwordEncoder.encode("123456"))
				.accessTokenValiditySeconds(7200)
				.authorizedGrantTypes("password", "refresh_token");
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) {
		security.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()")
				.passwordEncoder(this.passwordEncoder);
	}
}
