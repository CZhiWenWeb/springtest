package com.algs4.第一章.第一章1_3;

import java.util.Iterator;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-29 13:49
 * @UpdeteTime: 2019-05-29 13:49
 * @Description:
 */
public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node{
        Item item;
        Node next;
        Node pre;

        public Node(Item item) {
            this.item = item;
        }
    }

    public Deque() {
        this.N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    //向左端添加一个元素
    public void pushLeft(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
            N++;
        } else if (N == 1) {
            first = newNode;
            last.pre = first;
            first.next = last;
            N++;
        } else {
            Node fNode = first;
            first = newNode;
            fNode.pre = first;
            first.next = fNode;
            N++;
        }
    }

    //向右端添加一个元素
    public void pushRight(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
            N++;
        } else if (N == 1) {
            last = newNode;
            first.next = last;
            last.pre = first;
            N++;
        } else {
            Node lNode = last;
            last = newNode;
            lNode.next = last;
            last.pre = lNode;
            N++;
        }
    }

    //从左端删除一个元素
    public Item popLeft() throws Exception {
        if (isEmpty()) {
            throw new Exception("空队列");
        } else if (N == 1) {
            Item item = first.item;
            first = null;
            last = null;
            N--;
            return item;
        } else if (N == 2) {
            Item item=first.item;
            first.next = null;
            last.pre = null;
            first = last;
            N--;
            return item;
        } else {
            Item item=first.item;
            Node newFNode = first.next;
            first.next = null;
            first = newFNode;
            first.pre = null;
            N--;
            return item;
        }
    }

    //
    @Override
    public Iterator iterator() {
        return new ListNode();
    }
    private class ListNode implements Iterator<Item>{
        private Node curNode=first;
        @Override
        public boolean hasNext() {
            return curNode!=null;
        }

        @Override
        public Item next() {
            Item item=curNode.item;
            curNode=curNode.next;
            return item;
        }
    }
    public static void main(String[] args) throws Exception {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 5; i++) {
            deque.pushRight(i);
        }
        while (!deque.isEmpty()){
            System.out.println(deque.popLeft());
        }
    }
}
