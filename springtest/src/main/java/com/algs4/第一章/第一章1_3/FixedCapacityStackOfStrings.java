package com.algs4.第一章.第一章1_3;

import java.util.Stack;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-22 11:27
 * @UpdeteTime: 2019-05-22 11:27
 * @Description:
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;
    public FixedCapacityStackOfStrings(int cap){
        a=new String[cap];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void push(String item){
        a[N++]=item;
    }
    public boolean isFull(){
        return a.length>=N;
    }
    public String pop() throws Exception {
        if(N==0){
            throw new Exception("为空");
        }
        return a[--N];
    }

    public static void main(String[] args) throws Exception {
        FixedCapacityStackOfStrings f=new FixedCapacityStackOfStrings(3);
        f.pop();
        System.out.println(f.a);
    }
}
