package com.springbootjson.controller;

/**
 * @Author: czw
 * ①、如果finally中也有return，则会直接返回并终止程序，函数栈中的return不会被完成！；
 *
 * ②、如果finally中没有return，则在执行完finally中的代码之后，会将函数栈中的try中的
 * return的内容返回并终止程序；
 * @CreateTime: 2019-07-11 09:52
 * @UpdeteTime: 2019-07-11 09:52
 * @Description:
 */
public class try_test {
	public static void main(String[] args) {
		try {
			System.out.println(new try_test().testname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String testname() throws Exception {
		String t = "";

		try {
			t = "try";
			System.out.println("try");
			return t;
		} catch (Exception e) {
			// result = "catch";
			e.printStackTrace();
		}
		//finally {
		//
		//	System.out.println("finally");
		//	 //return t = "finally";
		//}
		return "return";
	}
}
