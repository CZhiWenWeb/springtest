package com.algs4.第一章.第一章1_3;


import java.util.Iterator;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-29 15:32
 * @UpdeteTime: 2019-05-29 15:32
 * @Description:动态数组实现双向队列
 */
public class ResizingArrayDeque<Item> implements Iterable<Item>{
    private Item[] a= (Item[]) new Object[1];
    private int N=0;
    //动态调整数组
    public void resize(int length){
        Item[] tmp= (Item[]) new Object[length];
        for (int i=0;i<a.length;i++){
            tmp[i]=a[i];
        }
        a=tmp;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public ResizingArrayDeque(){
    }
    //向左端添加元素
    public void pushLeft(Item item){
        if (a.length==size()){
            resize(a.length*2);
        }
        for (int i=N;i>0;i--){
            a[i]=a[i-1];
        }
        a[0]=item;
        N++;
    }
    //向右端添加元素
    public void pushRight(Item item){
        if (a.length==size()){
            resize(a.length*2);
        }
        a[N++]=item;
    }
    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> ddddd=new ResizingArrayDeque();
        for (int i=0;i<5;i++){
            ddddd.pushLeft(i);
        }
    }
}
