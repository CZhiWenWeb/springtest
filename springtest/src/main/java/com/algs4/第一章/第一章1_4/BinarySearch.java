package com.algs4.第一章.第一章1_4;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-03 09:39
 * @UpdeteTime: 2019-06-03 09:39
 * @Description:二分查找(数组必须不重复)
 */
public class BinarySearch {
    public static int rank(int key,int[] a){
        //数组必须有序
        int lo=0;
        int hi=a.length-1;
        while (lo<=hi){
            //被查找的键要么不存在，要么必然存在与a[lo..hi]之中
            int mid=lo+(hi-lo)/2;
            if (key<a[mid])
                hi=mid-1;
            else if (key>a[mid])
                lo=mid+1;
            else
                return mid;
        }
        return -1;
    }
}
