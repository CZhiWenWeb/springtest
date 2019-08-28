package com.xyx.shiro.config.redis;

import com.xyx.shiro.util.common.StringUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: czw
 * @CreateTime: 2019-08-24 16:07
 * @UpdeteTime: 2019-08-24 16:07
 * @Description:Jedis配置，项目启动注入JedisPool
 */
//开启config属性注入
//spring注解
@EnableAutoConfiguration
@PropertySource("classpath:config.properties")
@ConfigurationProperties(prefix = "redis")
@Configuration
//插件注解
@Getter
@Setter
@Slf4j
public class JedisConfig {
	private String host;

	private int port;

	private String password;

	private int timeout;

	@Value("${redis.pool.max-active}")
	private int maxActive;

	@Value("${redis.pool.max-wait}")
	private int maxWait;

	@Value("${redis.pool.max-idle}")
	private int maxIdle;

	@Value("${redis.pool.min-idle}")
	private int minIdle;

	@Bean
	public JedisPool redisPoolFactory() {
		try {
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			jedisPoolConfig.setMaxIdle(maxIdle);
			jedisPoolConfig.setMaxWaitMillis(maxWait);
			jedisPoolConfig.setMaxTotal(maxActive);
			jedisPoolConfig.setMinIdle(minIdle);
			// JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
			String pwd = StringUtil.isBlank(password) ? null : password;
			JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, pwd);
			log.info("初始化Redis连接池JedisPool成功!地址: " + host + ":" + port);
			return jedisPool;
		} catch (Exception e) {
			log.error("初始化Redis连接池JedisPool异常:" + e.getMessage());
		}
		return null;
	}
}
