package com.algs4.第一章.第一章1_4;

import java.util.Arrays;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-04 09:31
 * @UpdeteTime: 2019-06-04 09:31
 * @Description:
 */
public class StaticSETofInts {
    private int sum = 0;
    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    //二分查找
    private int rank(int key) {
        int h = 0;
        int l = a.length - 1;
        while (h <= l) {
            int temp = h + (l - h) / 2;
            if (a[temp] > key) {
                l = temp - 1;
            } else if (a[temp] < key) {
                h = temp + 1;
            } else {
                System.out.println(temp);
                return temp;
            }
        }
        return -1;
    }

    private int rank(int key, String s) {
        int h = 0;
        int l = a.length - 1;
        while (h <= l) {
            int temp = h + (l - h) / 2;
            if (a[temp] > key) {
                l = temp - 1;
            } else if (a[temp] < key) {
                h = temp + 1;
            } else {
                if (s == "min") {
                    while (a[temp - 1] == key) {
                        if (temp - 1 == 0) {
                            return 0;
                        } else {
                            temp--;
                        }
                    }
                    return temp;
                } else if (s == "max") {
                    while (a[temp + 1] == key) {
                        if (temp + 1 == a.length - 1) {
                            return a.length - 1;
                        } else {
                            temp++;
                        }
                    }
                    return temp;
                }
            }
        }
        return -1;
    }

    private int howMany(int key) {
        return rank(key,"max")-rank(key,"min")>=0?rank(key,"max")-rank(key,"min")+1:-1;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1,1};
        StaticSETofInts s = new StaticSETofInts(a);
        System.out.println(s.howMany(1));
    }
}
