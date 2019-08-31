package com.xyx.security.core.social.weixin.config;

import com.xyx.security.core.properties.SecurityProperties;
import com.xyx.security.core.social.CustomConnectedView;
import com.xyx.security.core.social.weixin.connect.WeiXinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.web.servlet.View;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 16:41
 * @UpdeteTime: 2019-08-31 16:41
 * @Description:微信配置自动注入
 */
@Configuration
@ConditionalOnProperty(prefix = "zx.security.social.weixin",name = "app-id")
public class WeiXinAutoConfig extends SocialConfigurerAdapter {
	@Autowired
	private SecurityProperties securityProperties;
	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer configurer,
	                                   Environment environment) {
		configurer.addConnectionFactory(createConnectionFactory());
	}

	public ConnectionFactory<?> createConnectionFactory(){
		SecurityProperties.SocialProperties.WeiXinProperties weixin = securityProperties.getSocial().getWeixin();
		return new WeiXinConnectionFactory(weixin.getProviderId(),weixin.getAppId(),weixin.getAppSecret());
	}
	// 这里需要返回null，否则会返回内存的 ConnectionRepository
	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		return null;
	}

	/**
	 * 业务用户登陆后, 绑定社交帐号 成功后的回调视图
	 * 此处可以用户自定义,当没有(name = "weixinConnectedView")bean时,才使用该bean
	 */
	@Bean({"connect/weixinConnected","connect/weixinConnect"})
	@ConditionalOnMissingBean(name = "weixinConnectedView")
	public View weixinConnectedView() {
		return new CustomConnectedView();
	}
}
