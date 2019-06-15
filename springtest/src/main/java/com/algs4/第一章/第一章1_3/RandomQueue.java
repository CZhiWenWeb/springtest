package com.algs4.第一章.第一章1_3;

import edu.princeton.cs.algs4.StdRandom;
import org.omg.CORBA.Object;

import java.util.Random;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-29 18:23
 * @UpdeteTime: 2019-05-29 18:23
 * @Description:
 */
public class RandomQueue<Item>{
    private Item[] items;
    private int N;
    public RandomQueue(){
        items = (Item[]) new Object[1];
        N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void resize(int length){
        Item[] temp= (Item[]) new Object[length];
        for (int i=0;i<N;i++){
            temp[i]=items[i];
        }
        items=temp;
    }
    public void enqueue(Item item){
        if (items.length==N){
            resize(items.length*2);
        }
        items[N++]=item;
    }
    public Item dequeue(){
        Random rand=new Random();
        int n=items.length;
        int r=rand.nextInt(n);
        Item temp=items[r];
        items[r]=items[n-1];
        items[n-1]=null;
        N--;
        if (N==n/4&&N>0){
            resize(n/2);
        }
        return temp;
    }
}
