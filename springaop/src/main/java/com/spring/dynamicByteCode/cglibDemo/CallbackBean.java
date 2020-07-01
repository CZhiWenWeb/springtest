package com.spring.dynamicByteCode.cglibDemo;

/**
 * @Author: czw
 * @CreateTime: 2020-07-01 14:52
 * @UpdeteTime: 2020-07-01 14:52
 * @Description:
 */
public class CallbackBean {
	public void methodForDispatcher() {
		System.out.println("methodForDispatcher");
	}

	public void methodForFixValue() {
		System.out.println("methodForFixValue");
	}

	public void methodForInvocationHandler() {
		System.out.println("methodForInvocationHandler");
	}

	public void methodForLazy() {
		System.out.println("methodForLazy");
	}

	public void methodForInterceptor() {
		System.out.println("methodForInterceptor");
	}

	public void methodForNoop() {
		System.out.println("methodForNoop");
	}
}
