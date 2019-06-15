package com.algs4.第二章.第二章2_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: czw
 * @CreateTime: 2019-06-13 10:02
 * @UpdeteTime: 2019-06-13 10:02
 * @Description:
 */
public class Template {
	public static int count=0;
	public static void sort(Comparable[] a) { /* 请见算法2.1、算法2.2、算法2.3、算法2.4、算法2.5或算法2.7*/ }

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void show(Comparable[] a) { // 在单行中打印数组
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) { // 测试数组元素是否有序
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1])) return false;
		return true;
	}
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		//将a[lo..mid]和a[mid+1..hi]归并
		int i=lo,j=mid+1;
		//for (int k=lo;k<=hi;k++)//将a[lo..hi]复制到aux[lo..hi]

	}
}
