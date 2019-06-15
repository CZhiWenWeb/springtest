package com.algs4.第一章.第一章1_3;

import java.util.Iterator;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-24 14:14
 * @UpdeteTime: 2019-05-24 14:14
 * @Description:
 */
public class Bag<Item> implements Iterable<Item>{
    private Node first;
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class Node{
        Item item;
        Node next;
    }
    public void add(Item item){
        Node oldfirst=first;
        first.item=item;
        first.next=oldfirst;
    }
    private class ListIterator implements Iterator<Item>{
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
