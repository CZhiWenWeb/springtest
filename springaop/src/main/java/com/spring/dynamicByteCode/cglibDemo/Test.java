package com.spring.dynamicByteCode.cglibDemo;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @Author: czw
 * @CreateTime: 2020-07-01 15:23
 * @UpdeteTime: 2020-07-01 15:23
 * @Description:
 */
public class Test {
	public static void main(String[] args) {

		//System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "target/cglib");
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CallbackBean.class);
		enhancer.setCallbacks(initCallBacks());
		enhancer.setCallbackFilter(initCallbackFilter());
		CallbackBean callbackBean = (CallbackBean) enhancer.create();
		callbackBean.methodForNoop();
		callbackBean.methodForInterceptor();
		callbackBean.methodForLazy();
		callbackBean.methodForLazy();
		callbackBean.methodForDispatcher();
		callbackBean.methodForDispatcher();
		callbackBean.methodForInvocationHandler();
		callbackBean.methodForFixValue();
	}

	private static final Callback[] initCallBacks() {
		MethodInterceptor methodInterceptor =
				new MethodInterceptorCallback();
		LazyLoader lazyLoader =
				new LazyLoaderCallback();
		InvocationHandler invocationHandler =
				new InvocationHandlerCallback();
		FixedValue fixedValue =
				new FixValueCallback();
		Dispatcher dispatcher =
				new DispatcherCallBack();
		Callback[] callbacks = new Callback[]
				{NoOp.INSTANCE, methodInterceptor, lazyLoader, dispatcher, invocationHandler, fixedValue};
		return callbacks;
	}

	private static final CallbackFilter initCallbackFilter() {
		return new CallbackFilter() {
			@Override
			public int accept(Method method) {
				if (method.getName().equals("methodForNoop")) {
					return 0;       //下标对应callbacks数组的下标，表示每个方法映射的callback
				}
				if (method.getName().equals("methodForInterceptor")) {
					return 1;
				}
				if (method.getName().equals("methodForLazy")) {
					return 2;
				}
				if (method.getName().equals("methodForDispatcher")) {
					return 3;
				}
				if (method.getName().equals("methodForInvocationHandler")) {
					return 4;
				}
				if (method.getName().equals("methodForFixValue")) {
					return 5;
				}
				return 0;
			}
		};
	}
}
