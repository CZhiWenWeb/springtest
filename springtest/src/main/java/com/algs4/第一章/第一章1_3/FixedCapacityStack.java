package com.algs4.第一章.第一章1_3;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable
{
    private Item[] a; // stack entries
    private int N; // size
    public FixedCapacityStack(int cap)
    { a = (Item[]) new Object[cap]; }
    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    public void push(Item item) {
        if(N==a.length)
            resize(2*a.length);
        a[N++] = item;
    }
    private void resize(int max){
        Item[] items= (Item[]) new Object[max];
        for (int i=0;i<N;i++){
            items[i]=a[i];
        }
        a=items;
    }
    public Item pop() {
        Item item=a[--N];
        a[N]=null;//避免对象游离
        if(N>0&&N==a.length/4)
            resize(a.length/2);
        return a[--N];
    }
    public static void main(String[] args) {
        FixedCapacityStack<Integer> fs=new FixedCapacityStack<>(5);
        fs.push(11);fs.push(22);fs.push(33);
        Iterator<Integer> i=fs.iterator();
        while (i.hasNext()){
            Integer s=i.next();
            System.out.println(s);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return a[--i]; }
        public void remove() { }
    }
}