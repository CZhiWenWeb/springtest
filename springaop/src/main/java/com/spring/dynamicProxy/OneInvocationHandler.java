package com.spring.dynamicProxy;

import com.spring.common.Entity;
import com.spring.common.OneInteface;
import com.spring.common.OtherInteface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: czw
 * @CreateTime: 2020-07-01 10:29
 * @UpdeteTime: 2020-07-01 10:29
 * @Description: InvocationHandler实例用于生成动态代理类（instanceOf Proxy）,动态代理类
 * 通过InvocationHandler实例的invoke方法执行代理的接口方法，动态代理类除了
 * 代理方法外，还默认存在toString,equals,hashCode方法。
 * 参数proxy为生成的代理类，Method为被代理的接口，args为接口参数
 * InvocationHandler相当于AOP中的advice，是横切逻辑载体
 * <p>
 * 使用方式：动态代理类实现了代理接口，将动态代理类向上塑性为代理接口，执行代理接口即可。
 * java支持多接口实现，所以可以同时代理多个接口，对于没有实现接口的类无法提供服务。
 */
public class OneInvocationHandler implements InvocationHandler {

	private Entity entity;

	public OneInvocationHandler(Entity entity) {
		this.entity = entity;
	}

	/**
	 *切记不要用proxy去invoke，代理类通过以下形式执行方法：super.h.invoke(null, m3, null);
	 * h指向的就是当前实例，会无限循环
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object o;
		if (method.equals(OtherInteface.class.getDeclaredMethod("otherSay"))) {
			o = method.invoke(entity, args);
			System.out.println("Hello other");
		} else if (method.equals(OneInteface.class.getDeclaredMethod("say"))) {
			o = method.invoke(entity, args);
			System.out.println("Hello one");
		} else {
			o = method.invoke(entity, args);    //除了代理方法，能执行的只有其他三个方法
			System.out.println("hello world");
		}
		return o;
	}
}
