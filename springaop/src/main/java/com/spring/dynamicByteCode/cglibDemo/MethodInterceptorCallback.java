package com.spring.dynamicByteCode.cglibDemo;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: czw
 * @CreateTime: 2020-07-01 15:02
 * @UpdeteTime: 2020-07-01 15:02
 * @Description:生成代理类字节码，对方法进行拦截调用；
 * 所有被代理的方法都调用这个方法，而不是原方法（实际为子类方法）。原方法可以通过反射进行调用
 */
public class MethodInterceptorCallback implements MethodInterceptor {
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("before invoke");
		proxy.invokeSuper(obj, args);
		System.out.println("after invoke");
		return null;
	}
}
