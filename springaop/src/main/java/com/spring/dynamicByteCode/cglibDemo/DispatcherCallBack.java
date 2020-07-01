package com.spring.dynamicByteCode.cglibDemo;

import net.sf.cglib.proxy.Dispatcher;

/**
 * @Author: czw
 * @CreateTime: 2020-07-01 14:42
 * @UpdeteTime: 2020-07-01 14:42
 * @Description: 实现Dispatcher接口，要求实现loadObject方法，返回期望的代理类。loadObject方法
 * 在每次调用被拦截方法的时候都会被调用一次
 */
public class DispatcherCallBack implements Dispatcher {
	@Override
	public Object loadObject() throws Exception {
		System.out.println("dispatcherCallBack........");
		CallbackBean callbackBean = new CallbackBean();
		return callbackBean;
	}
}
