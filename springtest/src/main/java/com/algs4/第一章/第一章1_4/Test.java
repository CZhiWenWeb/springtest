package com.algs4.第一章.第一章1_4;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-03 11:44
 * @UpdeteTime: 2019-06-03 11:44
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        for (int i=10;i<20;i++){
            invoke(i);
        }
    }
    public static void invoke(int N){
        int oldN=N;
        int count=0;
        while (N/2>0){
            N=N/2;
            count++;
        }
        System.out.println(oldN+" "+count);
    }
}
