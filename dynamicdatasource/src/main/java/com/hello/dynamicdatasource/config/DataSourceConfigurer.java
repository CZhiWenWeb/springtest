package com.hello.dynamicdatasource.config;

import com.hello.dynamicdatasource.common.DataSourceKey;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: czw
 * @CreateTime: 2019-08-13 13:45
 * @UpdeteTime: 2019-08-13 13:45
 * @Description:
 */
@Configuration
public class DataSourceConfigurer {
	@Bean("master")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.hikari.master")
	public DataSource master(){
		return DataSourceBuilder.create().build();
	}

	@Bean("slaveAlpha")
	@ConfigurationProperties(prefix = "spring.datasource.hikari.slave-alpha")
	public DataSource slaveAlpha(){
		return DataSourceBuilder.create().build();
	}

	@Bean("slaveBeta")
	@ConfigurationProperties(prefix = "spring.datasource.hikari.slave-beta")
	public DataSource slaveBeta(){
		return DataSourceBuilder.create().build();
	}

	@Bean("slaveGamma")
	@ConfigurationProperties(prefix = "spring.datasource.hikari.slave-gamma")
	public DataSource slaveGamma(){
		return DataSourceBuilder.create().build();
	}

	@Bean("dynamicDataSource")
	public DataSource dynamicDataSource(){
		DynamicRoutingDataSource dynamicRoutingDataSource=new DynamicRoutingDataSource();
		Map<Object,Object> dataSourceMap=new HashMap<>(DataSourceKey.values().length);
		dataSourceMap.put(DataSourceKey.master.name(),master());
		dataSourceMap.put(DataSourceKey.slaveBeta.name(), slaveBeta());
		dataSourceMap.put(DataSourceKey.slaveGamma.name(), slaveGamma());

		dynamicRoutingDataSource.setDefaultTargetDataSource(master());

		dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
		// To put datasource keys into DataSourceContextHolder to judge if the datasource is exist
		DynamicDataSourceContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());

		// To put slave datasource keys into DataSourceContextHolder to load balance
		DynamicDataSourceContextHolder.slaveDataSourceKeys.addAll(dataSourceMap.keySet());
		DynamicDataSourceContextHolder.slaveDataSourceKeys.remove(DataSourceKey.master.name());

		return dynamicRoutingDataSource;
	}


	@Bean
	//@ConfigurationProperties(prefix = "mybatis")
	public SqlSessionFactoryBean sqlSessionFactoryBean(){
		SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();

		sessionFactoryBean.setDataSource(dynamicDataSource());
		return sessionFactoryBean;
	}
	@Bean
	public PlatformTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dynamicDataSource());
	}
}
