package com.algs4.Utils;

import java.util.Iterator;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-09 08:39
 * @UpdeteTime: 2019-06-09 08:39
 * @Description: 一个以栈为目标的队列，支持push, pop, enqueue
 */
public class Steque<Item>{
	private Stack<Item> stack1=new Stack<>();
	private Stack<Item> stack2=new Stack<>();
	private int N;
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return stack1.isEmpty();
	}
	public void push(Item item){
		stack1.push(item);
		N++;
	}

	public Item pop() throws Exception {
		N--;
		return stack1.pop();
	}

	public void enqueue(Item item) throws Exception {
		while (!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		stack1.push(item);
		while (!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		N++;
	}
}
