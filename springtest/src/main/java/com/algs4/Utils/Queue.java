package com.algs4.Utils;

import java.util.Iterator;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-06 11:45
 * @UpdeteTime: 2019-06-06 11:45
 * @Description: 链表实现队列
 */
public class Queue<Item> implements Iterable<Item>{
	private class Node{
		Item item;
		Node next;
		public Node(Item item){
			this.item=item;
		}
	}
	private Node first;//指向最早添加的节点
	private Node last;//指向最进添加的节点
	private int N;
	public Queue(){
		this.first=null;
		this.last=null;
		this.N=0;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public int size(){
		return N;
	}
	//向底部插入元素
	public void enqueue(Item item){
		Node newNode=new Node(item);
		if (isEmpty()){
			first=newNode;
			last=newNode;
			N++;
		}else {
			last.next=newNode;
			last=newNode;
			N++;
		}
	}
	//往顶部去出元素
	public Item dequeue() throws Exception {
		if (isEmpty()){
			throw new Exception("空队列");
		}else {
			Item item=first.item;
			first=first.next;
			if (isEmpty()){
				last=null;
			}
			N--;
			return item;
		}
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		Node current=first;
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			Item item=current.item;
			current=current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		Queue queue=new Queue<Integer>();
		for (int i=0;i<5;i++){
			queue.enqueue(i);
		}
	}
}
