package com.algs4.第一章.第一章1_3;

import java.util.Iterator;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-24 11:31
 * @UpdeteTime: 2019-05-24 11:31
 * @Description:
 */
public class Queue<Item> implements Iterable{
    private Node first;//指向最早添加的节点的链接
    private Node last;//指向最近添加的节点链接
    private int N;//队列中的元素数量
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    public void enqueue(Item item){
        Node oldLast=last;
        last.item=item;
        last.next=null;
        if(isEmpty()){
            first=last;
        }else {
            oldLast.next=last;
        }
        N++;
    }
    public Item dequeue(){
        Item item=first.item;
        first=first.next;
        if (isEmpty())
            last=null;
        return item;
    }
    @Override
    public Iterator iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        Node fCurrent=first;
        @Override
        public boolean hasNext() {
            return fCurrent!=null;
        }

        @Override
        public Item next() {
            Item item=first.item;
            fCurrent=fCurrent.next;
            return item;
        }
    }
}
