package com.algs4.第一章.第一章1_4;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-03 14:57
 * @UpdeteTime: 2019-06-03 14:57
 * @Description:
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9,1};
//        binary(a);
//        System.out.println("--------------------");
        bise(a);
    }
    public static void binary(int[] a){
        int N=a.length;
        int sum=0;
        Stopwatch stopwatch=new Stopwatch();
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                if (a[i]==a[j])
                  sum++;
            }
        }
        stopwatch.elapsedTime();
        System.out.println(sum);
    }
    public static void bise(int[] a){
        int N=a.length;
        int sum=0;
        Arrays.sort(a);
        Stopwatch stopwatch=new Stopwatch();
        for (int i=0;i<N;i++) {
            int h=i;
            int l=N-1;
            int temp=a[i];
            while (l>h){
                int index=h+(l-h)/2;
                if (temp==a[index]){
                    sum++;
                    break;
                }else if (temp>a[index]){
                    h=index+1;
                }else {
                    l=index-1;
                }
            }
        }
        stopwatch.elapsedTime();
        System.out.println(sum);
    }
}
