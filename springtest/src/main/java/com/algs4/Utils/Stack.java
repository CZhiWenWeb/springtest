package com.algs4.Utils;

import java.util.Iterator;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-06 11:16
 * @UpdeteTime: 2019-06-06 11:16
 * @Description: 链表实现下压堆栈
 */
public class Stack<Item> implements Iterable<Item> {

	private class Node {
		Item item;
		Node next;

		public Node(Item item) {
			this.item = item;
		}
	}

	private Node first;//栈顶 最近添加的元素
	private int N;//元素数量

	public Stack() {
		this.N = 0;
		this.first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	//向栈顶添加元素
	public void push(Item item) {
		Node newNode = new Node(item);
		Node oldFist = first;
		first = newNode;
		first.next = oldFist;
		N++;
	}

	//在栈顶弹出元素
	public Item pop() throws Exception {
		if (isEmpty()){
			throw new Exception("栈为空");
		}else {
			Item item=first.item;
			first=first.next;
			N--;
			return item;
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current=first;
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
}
