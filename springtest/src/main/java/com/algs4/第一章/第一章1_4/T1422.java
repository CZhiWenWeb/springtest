package com.algs4.第一章.第一章1_4;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-05 14:28
 * @UpdeteTime: 2019-06-05 14:28
 * @Description:仅用加减实现的二分查找
 */
public class T1422 {
	public int findInt(int[] a, int num) {
		int fn1=1;
		int fn=1;
		while (fn<a.length){
			fn=fn1+fn;
			fn1=fn-fn1;
		}
		int head=0;
		int last=a.length-1;
		return -1;
	}

	public static void main(String[] args) {
		int[] array = {1, 5, 15, 22, 25, 31, 39, 42, 47, 49, 59, 68, 88, 88,
				88, 88, 88};
		T1422 t = new T1422();
		System.out.println(t.findInt(array, 31));
	}
}
