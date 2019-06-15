package com.algs4.第一章.第一章1_3;

import java.util.Iterator;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-28 15:23
 * @UpdeteTime: 2019-05-28 15:23
 * @Description:
 */
public class MyQueue<Item> implements Iterable<Item>{
    private Node first;//头
    private Node last;//尾
    private int N;//长度

    @Override
    public Iterator<Item> iterator() {
        return new MyQueueIterator();
    }
    private class MyQueueIterator implements Iterator<Item>{
        Node curNode=first;
        @Override
        public boolean hasNext() {
            return N>0;
        }

        @Override
        public Item next() {
            Item item=curNode.item;
            curNode=curNode.next;
            N--;
            return item;
        }
    }
    private class Node {
        Item item;
        Node next;
    }

    public MyQueue() {
        this.first = null;
        this.last = null;
        this.N = 0;
    }
    public MyQueue (MyQueue queue){
        Iterator<Item> iterator=queue.iterator();
        while (iterator.hasNext()){
            Item item= iterator.next();
            Node newNode=new Node();
            newNode.item=item;
            if (N==0){
                first=newNode;
                last=newNode;
                N++;
            }else if (N==1){
                last=newNode;
                first.next=last;
                N++;
            }else {
                Node lNode=last;
                lNode.next=newNode;
                last=newNode;
                N++;
            }
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (first == null) {//为空
            first = newNode;
            last = newNode;
            first.next = last;
            last.next = first;
            N++;
        } else {
            Node fNode = last;
            fNode.next = newNode;
            last = newNode;
            last.next = first;
            N++;
        }
    }

    public Item dequeue() throws Exception {
        if (first == null) {
            throw new Exception("链表为空");
        } else {
            Node fNode = first;
            Node lNode = last;
            Node newFNode = fNode.next;
            if (first == last) {
                Item item = fNode.item;
                first = null;
                last = null;
                N = 0;
                return item;
            } else if (newFNode == last) {
                Item item = fNode.item;
                fNode.next = null;
                first = lNode;
                first.next = last;
                last.next = first;
                N--;
                return item;
            } else {
                Item item = fNode.item;
                fNode.next = null;
                first = newFNode;
                last.next = first;
                N--;
                return item;
            }
        }
    }

    //测试用例
    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 5; i++) {
            myQueue.enqueue(i);
        }
        MyQueue queue=new MyQueue(myQueue);

    }
}
