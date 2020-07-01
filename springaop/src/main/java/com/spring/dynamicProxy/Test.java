package com.spring.dynamicProxy;

import com.spring.common.Entity;
import com.spring.common.OneInteface;
import com.spring.common.OtherInteface;

import java.lang.reflect.Proxy;

/**
 * @Author: czw
 * @CreateTime: 2020-07-01 10:58
 * @UpdeteTime: 2020-07-01 10:58
 * @Description:
 */
public class Test {
	public static void main(String[] args) {
		Entity entity = new Entity();
		Object o = Proxy.newProxyInstance(entity.getClass().getClassLoader(),
				new Class[]{OneInteface.class, OtherInteface.class}, new OneInvocationHandler(entity));
		OneInteface one = (OneInteface) o;
		one.say();
		OtherInteface other = (OtherInteface) o;
		other.otherSay();
		o.toString();
		o.hashCode();
		o.equals("");
		o.getClass();
	}
}
