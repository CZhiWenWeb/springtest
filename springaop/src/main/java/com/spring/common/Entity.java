package com.spring.common;

/**
 * @Author: czw
 * @CreateTime: 2020-07-01 10:26
 * @UpdeteTime: 2020-07-01 10:26
 * @Description:
 */
public class Entity implements OneInteface, OtherInteface {
	@Override
	public void say() {
		System.out.println("I am one");
	}

	@Override
	public void otherSay() {
		System.out.println("I am other");
	}
}
