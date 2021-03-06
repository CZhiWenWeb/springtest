package com.spring.dynamicByteCode;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;

/**
 * @Author: czw
 * @CreateTime: 2020-07-01 11:18
 * @UpdeteTime: 2020-07-01 11:18
 * @Description: cglib官方使用示例
 */
public class Trace implements MethodInterceptor {
	int ident = 1;
	static Trace callback = new Trace();

	private Trace() {
	}

	public static Object newInstance(Class clazz) {
		try {
			Enhancer e = new Enhancer();
			e.setSuperclass(clazz);
			e.setCallback(callback);
			return e.create();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}
	}

	public static void main(String[] args) {
		List list = (List) newInstance(Vector.class);
		Object value = "TEST";
		list.add(value);
		list.contains(value);

		try {
			list.set(2, "ArrayIndexOutOfBounds");
		} catch (ArrayIndexOutOfBoundsException i) {
		}

		list.add(value + "1");
		list.add(value + "2");
		list.toString();
		list.equals(list);
		list.add(list);
		list.equals(list);
		list.set(0, null);
		list.toString();
		list.add(list);
		list.get(1);
		list.toArray();
		list.remove(list);
		list.remove("");
		list.containsAll(list);
		list.lastIndexOf(value);

 	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		printIdent(ident);
		System.out.println(method);
		for (int i = 0; i < args.length; i++) {
			printIdent(ident);
			System.out.println("arg" + (i + 1) + ":");
			if (obj == args[i])
				System.out.println("this");
			else
				System.out.println(args[i]);
		}
		ident++;

		Object retValFromSuper = null;
		try {
			retValFromSuper = proxy.invokeSuper(obj, args);
		} catch (Throwable t) {
			ident--;
			printIdent(ident);
			System.out.println("throw" + t);
			System.out.println();
			throw t.fillInStackTrace();
		}

		printIdent(ident);
		System.out.println("return ");
		if (obj == retValFromSuper)
			System.out.println("this");
		else
			System.out.println(retValFromSuper);

		if (ident == 1)
			System.out.println();

		return retValFromSuper;
	}

	void printIdent(int ident) {
		while (--ident > 0) {
			System.out.println("....");
		}
		System.out.println(" ");
	}
}
