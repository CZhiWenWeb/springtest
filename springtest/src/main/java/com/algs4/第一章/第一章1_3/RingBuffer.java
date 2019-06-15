package com.algs4.第一章.第一章1_3;

import org.omg.CORBA.Object;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-01 11:17
 * @UpdeteTime: 2019-06-01 11:17
 * @Description:
 */
public class RingBuffer<Item> {
    private Item[] items= (Item[]) new Object[10];
    private Integer N=0;
    public boolean isFull(){
        return N==10;
    }
    public boolean isEmpty(){
        return N==0;
    }

}
