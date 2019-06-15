package com.algs4.第一章.第一章1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-03 09:27
 * @UpdeteTime: 2019-06-03 09:27
 * @Description:2-sum
 */
public class TwoSumFast {
    public static int count(int[] a){
        Arrays.sort(a);
        int N=a.length;
        int cnt=0;
        for (int i=0;i<N;i++){
            if (BinarySearch.rank(-a[i],a)>i)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a= In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
