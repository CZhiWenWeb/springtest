package com.example.Test;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-07-18 09:18
 * @UpdeteTime: 2019-07-18 09:18
 * @Description:
 */
public class Test1 {
	public static void main(String[] args) {
		B b1=new B();
		B b2=new B();
		List<Object> list=new ArrayList<>();
		list.add(b1);
		B b= (B) list.get(0);
	}
}
interface A{
}
@Data
class B implements A{
	private int age;
	private String name;
}
