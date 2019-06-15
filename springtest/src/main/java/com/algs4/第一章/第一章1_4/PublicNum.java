package com.algs4.第一章.第一章1_4;


import java.util.Arrays;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-04 11:47
 * @UpdeteTime: 2019-06-04 11:47
 * @Description:打印两个有序数组的公有元素
 */
public class PublicNum {
    public void commonNum(int[] a,int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i=0,j=0;i<a.length&&j<b.length;){
            if (a[i]==b[j]){
                System.out.println("a:"+a[i]);
                System.out.println("b:"+b[j]);
                while (i+1<a.length&&a[i]==a[i+1]){
                    i++;
                    System.out.println("a:"+a[i]);
                }
                while (j+1<b.length&&b[j]==b[j+1]){
                    j++;
                    System.out.println("b:"+b[j]);
                }
                i++;
                j++;
            }else if (a[i]<b[j]){
                i++;
            }else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a={1,1,1,1,1,1,1,3,3,5};
        int[] b={1,3,23,5,6};
        PublicNum publicNum=new PublicNum();
        publicNum.commonNum(a,b);
    }
}
