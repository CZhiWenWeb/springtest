package com.spring.dynamicByteCode.cglibDemo;

import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @Author: czw
 * @CreateTime: 2020-07-01 14:47
 * @UpdeteTime: 2020-07-01 14:47
 * @Description:
 *不推荐使用，建议java.lang.reflect.InvocationHandler代替
 */
public class InvocationHandlerCallback implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invocationHandlerCallback before");
		method.invoke(proxy.getClass().getSuperclass().newInstance(),args);
		System.out.println("invocationHandlerCallback after");
		return null;
	}
}
