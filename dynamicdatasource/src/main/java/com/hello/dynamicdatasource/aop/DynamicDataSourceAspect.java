package com.hello.dynamicdatasource.aop;

import com.hello.dynamicdatasource.config.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-08-13 14:32
 * @UpdeteTime: 2019-08-13 14:32
 * @Description:不指定数据源通过切面动态切换数据源
 */
@Component
@Aspect
public class DynamicDataSourceAspect {
	//private final String[] QUERY_PREFIX={"Product"};

	@Pointcut("execution(* com.hello.dynamicdatasource.service.impl.*.*(..))")
	public void daoAspect(){}

	@Before("daoAspect()")
	public void switchDataSource(JoinPoint point){
		System.out.println("before-----------");
		//Boolean isQueryMethod=isQueryMethod(point.getSignature().getName());
		//if (isQueryMethod){
			DynamicDataSourceContextHolder.useSlaveDataSource();
		//}
	}

	@After("daoAspect()")
	public void restoreDataSource(JoinPoint point){
		System.out.println("after-----------");
		DynamicDataSourceContextHolder.clearDataSourceKey();
	}
	//private Boolean isQueryMethod(String methodName){
	//	for (String suffix:QUERY_PREFIX
	//	     ) {
	//		if (methodName.endsWith(suffix)){
	//			return true;
	//		}
	//	}
	//	return false;
	//}
}
