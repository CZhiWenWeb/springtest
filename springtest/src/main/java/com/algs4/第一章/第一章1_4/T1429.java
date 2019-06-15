package com.algs4.第一章.第一章1_4;


import com.algs4.Utils.Stack;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-06 15:00
 * @UpdeteTime: 2019-06-06 15:00
 * @Description:两个栈实现的steque
 */
public class T1429<Item> {
	private Stack<Item> stack1=new Stack<>();
	private Stack<Item> stack2=new Stack<>();
	public void Push(Item item){

	}
	private void resverseStack1() throws Exception {
		while (!this.stack1.isEmpty()){
			this.stack2.push(this.stack1.pop());
		}
	}
}
