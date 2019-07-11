package com.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: czw
 * @CreateTime: 2019-07-08 10:22
 * @UpdeteTime: 2019-07-08 10:22
 * @Description:
 */
@Configuration
@MapperScan(basePackages = Mytest1DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "mysqlSqlSessionFactory1")
public class Mytest1DataSourceConfig {
	/**
	 * mysql扫描路径
	 */
	static final String PACKAGE= "com/mysql1dao";
	///使用mapper注解
	// **
	// * mybatis mapper扫描路径
	// */
	//static final String MAPPER_LOCATION="classpath:mapper/mysql/*.xml";

	/**
	 * 一个接口的有多个实现类，选择默认采用的一个
	 * @return
	 */
	@Primary
	@Bean(name = "mysqldatasource1")
	@ConfigurationProperties("spring.datasource.druid.mysql1")
	public DataSource mysql1DataSource(){
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlTransactionManger1")
	public DataSourceTransactionManager mysqlTransactionManager(){
		return new DataSourceTransactionManager(mysql1DataSource());
	}

	@Primary
	@Bean(name = "mysqlSqlSessionFactory1")
	public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqldatasource1")DataSource dataSource)
		throws Exception{
		final SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		return sessionFactoryBean.getObject();
	}
}
