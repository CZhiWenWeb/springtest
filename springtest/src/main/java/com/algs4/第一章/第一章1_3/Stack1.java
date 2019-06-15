package com.algs4.第一章.第一章1_3;


import java.util.Iterator;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-24 11:07
 * @UpdeteTime: 2019-05-24 11:07
 * @Description:
 */
public class Stack1<Item> implements Iterable<Item>{
    private Node first;
    private int N;
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
    public void push(Item item){
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }
    public Item peek(){
        return first.item;
    }
    public Item pop(){
        Item item=first.item;
        first=first.next;
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
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
    public static void main(String[] args) {
        Stack1<Integer> stack=new Stack1<>();
        for (int i=0;i<5;i++){
            stack.push(i);
        }
        Iterator<Integer> integerIterator=stack.iterator();
        while (integerIterator.hasNext()){
            System.out.println(stack.pop());
        }
    }
}
