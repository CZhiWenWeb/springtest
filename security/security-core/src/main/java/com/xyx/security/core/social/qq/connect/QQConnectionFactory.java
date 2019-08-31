package com.xyx.security.core.social.qq.connect;

import com.xyx.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 15:43
 * @UpdeteTime: 2019-08-31 15:43
 * @Description:
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {
	/**
	 * 唯一构造函数，需要服务商id,自定义字符串；也是后面添加social的过滤，过滤器帮我们拦截的url其中的某一段地址
	 * @param providerId
	 * @param appId
	 * @param appSecret
	 */
	public QQConnectionFactory(String providerId, String appId, String appSecret) {
		/**
		 * serviceProvider 用于执行授权流和获取本机服务API实例的ServiceProvider模型
		 * apiAdapter      适配器，用于将不同服务提供商的个性化用户信息映射到
		 */
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
	}
}
