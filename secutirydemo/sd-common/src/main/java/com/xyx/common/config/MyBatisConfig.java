package com.xyx.common.config;

import com.xyx.common.interceptor.SqlStatementInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: czw
 * @CreateTime: 2019-08-29 15:33
 * @UpdeteTime: 2019-08-29 15:33
 * @Description:
 */
@Configuration
public class MyBatisConfig {
	/**
	 * 配置sql打印拦截器，febs.showsql为true时生效
	 * @return
	 */
	@Bean
	@ConditionalOnProperty(name = "febs.showsql", havingValue = "true")
	SqlStatementInterceptor sqlStatementInterceptor() {
		return new SqlStatementInterceptor();
	}
}
