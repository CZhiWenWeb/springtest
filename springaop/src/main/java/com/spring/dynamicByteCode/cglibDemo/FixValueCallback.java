package com.spring.dynamicByteCode.cglibDemo;

import net.sf.cglib.proxy.FixedValue;

/**
 * @Author: czw
 * @CreateTime: 2020-07-01 14:43
 * @UpdeteTime: 2020-07-01 14:43
 * @Description:
 *相当于重写了相应的函数实现，并不会调用原函数
 */
public class FixValueCallback implements FixedValue {

	@Override
	public Object loadObject() throws Exception {
		System.out.println("this is fixvalue callback... overwrite the code");
		return true;
	}
}
