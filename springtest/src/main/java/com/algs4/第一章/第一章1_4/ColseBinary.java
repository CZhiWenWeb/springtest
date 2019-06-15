package com.algs4.第一章.第一章1_4;

import java.util.Arrays;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-04 16:18
 * @UpdeteTime: 2019-06-04 16:18
 * @Description:最接近的两个数
 */
public class ColseBinary {
    public static void main(String[] args) {

    }
    public void binary(Double[] a){
        Arrays.sort(a);
        Double dif=Math.abs(a[a.length-1]);
        for (int i=0;i<a.length-1;i++){
            if (a[i+1]-a[i]<dif){
                dif=a[i+1]-a[i];
            }
        }
        System.out.println(dif);
    }
}
