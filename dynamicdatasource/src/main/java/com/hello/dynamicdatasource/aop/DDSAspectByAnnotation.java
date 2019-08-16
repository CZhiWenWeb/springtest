package com.hello.dynamicdatasource.aop;

import com.hello.dynamicdatasource.annotation.DataSource;
import com.hello.dynamicdatasource.config.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-08-15 14:11
 * @UpdeteTime: 2019-08-15 14:11
 * @Description:通过annotation指定数据源
 */
@Aspect
@Component
public class DDSAspectByAnnotation {
	@Before("@annotation(ds)")
	public void changeDataSource(JoinPoint point, DataSource ds){
		String dsId=ds.name();
		System.out.println(dsId);
		if (DynamicDataSourceContextHolder.containDataSourceKey(dsId)){

		}else {

		}
	}
}
