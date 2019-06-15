package com.algs4.第一章.第一章1_3;


import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.Random;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-29 16:36
 * @UpdeteTime: 2019-05-29 16:36
 * @Description:
 */
public class RandomBag<Item> implements Iterable<Item>{
    private Item[] a= (Item[]) new Object[1];
    private int N=0;
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    //动态数组
    public void resize(int lenght){
        Item[] tmp= (Item[]) new Object[lenght];
        for (int i=0;i<a.length;i++){
            tmp[i]=a[i];
        }
        a=tmp;
    }
    public void add(Item item){
        if (a.length==N){
            resize(a.length*2);
        }
        a[N++]=item;
    }
    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
