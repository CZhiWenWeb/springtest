package com.algs4.第一章.第一章1_4;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-03 11:34
 * @UpdeteTime: 2019-06-03 11:34
 * @Description: 三元组
 */
public class ThreeSumFast {
    public static int count(int[] a){
        Arrays.sort(a);
        int N=a.length;
        int cnt=0;
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                if (BinarySearch.rank(-a[i]-a[j],a)>j)
                    cnt++;
            }
        }
        return cnt;
    }
}
