package com.algs4.第二章.第二章2_2;

import com.algs4.第二章.第二章2_1.Shell;

import static com.algs4.第二章.第二章2_2.Merge.merge;

/**
 * @Author: czw
 * @CreateTime: 2019-06-15 13:47
 * @UpdeteTime: 2019-06-15 13:47
 * @Description:
 */
public class MergeBU {
	private static Comparable[] aux;

	public void sort(Comparable[] a) {
		int N=a.length;
		aux=new Comparable[N];
		for (int sz=1;sz<N;sz+=sz)//sz子数组大小
			for (int lo=0;lo<N-sz;lo+=sz+sz)//lo:子数组索引
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
	}
}
