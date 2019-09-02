package com.xyx.security.social;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.concurrent.TimeUnit;

/**
 * @Author: czw
 * @CreateTime: 2019-09-02 14:09
 * @UpdeteTime: 2019-09-02 14:09
 * @Description:app模块处理注册时 社交账号信息存储等操作的工具类
 */
@Component
public class AppSignUpUtils {
	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;
	//将社交用户信息和系统用户id存入关联表
	@Autowired
	private UsersConnectionRepository usersConnectionRepository;
	//用来获取ConnectionFactory
	@Autowired
	private ConnectionFactoryLocator connectionFactoryLocator;
	/**
	 *  保存社交用户信息
	 * @param request
	 * @param connectionData 社交登录成功的社交用户信息
	 */
	public void saveConnetionData(WebRequest request, ConnectionData connectionData) {
		redisTemplate.opsForValue().set(getKey(request),connectionData,10, TimeUnit.MINUTES);
	}

	public void doPostSignUp( String userId,WebRequest request) {
		//获取 用户社交帐号信息
		String key = getKey(request);
		if (!redisTemplate.hasKey(key)) {
			throw new RuntimeException("无法找到缓存的用户社交帐号信息");
		}
		ConnectionData connectionData = (ConnectionData) redisTemplate.opsForValue().get(key);

		//用ConnectionData 创建 Connection ,以存入关联表
		Connection<?> connection = connectionFactoryLocator
				.getConnectionFactory(connectionData.getProviderId())
				.createConnection(connectionData);
		//在关联表创建对应userId(业务系统id)的记录,并关联对应社交帐号
		usersConnectionRepository.createConnectionRepository(userId).addConnection(connection);

		//完成后删除缓存
		redisTemplate.delete(key);
	}

	private String getKey(WebRequest request) {
		//获取请求头中的设备id
		String deviceId = request.getHeader("deviceId");
		if (StringUtils.isBlank(deviceId)) {
			throw new RuntimeException("设备id参数不能为空");
		}
		return "zx:security:social.connect." + deviceId;
	}
}
