package com.algs4.第一章.第一章1_4;


import com.algs4.Utils.Stack;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-06 10:59
 * @UpdeteTime: 2019-06-06 10:59
 * @Description:两个栈实现队列
 */
public class T1427<Item> {
	private Stack<Item> enstack=new Stack<>();
	private Stack<Item> destack=new Stack<>();
	private int N;

	public boolean isEmpty(){
		return enstack.isEmpty();
	}
	public int size(){
		return N;
	}
	public void enqueue(Item item){
		enstack.push(item);
		N++;
	}
	public Item dequeue() throws Exception {
		while (!enstack.isEmpty()){
			destack.push(enstack.pop());
		}
		Item item=destack.pop();
		N--;
		while (!destack.isEmpty()){
			enstack.push(destack.pop());
		}
		return item;
	}

	public static void main(String[] args) throws Exception {
		T1427 t=new T1427<Integer>();
		for (int i=0;i<5;i++){
			t.enqueue(i);
		}
		while (!t.isEmpty()){
			System.out.println(t.dequeue());
		}
	}
}
