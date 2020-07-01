package com.spring.dynamicByteCode.cglibDemo;

import net.sf.cglib.proxy.LazyLoader;

/**
 * @Author: czw
 * @CreateTime: 2020-07-01 15:26
 * @UpdeteTime: 2020-07-01 15:26
 * @Description:
 * 只有第一次调用的时候初始化，之后不在重新调用，初始化时进行成员的赋值，
 * 之后使用该成员进行调用父类方法
 */
public class LazyLoaderCallback implements LazyLoader {
	@Override
	public Object loadObject() throws Exception {
		System.out.println("lazyLoader......");
		CallbackBean callbackBean = new CallbackBean();
		return callbackBean;
	}
}
