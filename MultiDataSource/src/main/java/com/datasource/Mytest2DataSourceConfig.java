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
 * @CreateTime: 2019-07-08 14:15
 * @UpdeteTime: 2019-07-08 14:15
 * @Description:
 */
@Configuration
@MapperScan(basePackages = Mytest2DataSourceConfig.PACKAGE,
		sqlSessionFactoryRef = "mysqlSqlSessionFactory2")
public class Mytest2DataSourceConfig {
	/**
	 * mysql扫描路径
	 */
	static final String PACKAGE= "com/mysql2dao";
	///使用mapper注解
	// **
	// * mybatis mapper扫描路径
	// */
	//static final String MAPPER_LOCATION="classpath:mapper/mysql/*.xml";

	@Bean(name = "mysqldatasource2")
	@ConfigurationProperties("spring.datasource.druid.mysql2")
	public DataSource mysql1DataSource(){
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlTransactionManger2")
	public DataSourceTransactionManager mysqlTransactionManager(){
		return new DataSourceTransactionManager(mysql1DataSource());
	}

	@Bean(name = "mysqlSqlSessionFactory2")
	public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqldatasource2")DataSource dataSource)
			throws Exception{
		final SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		return sessionFactoryBean.getObject();
	}
}
