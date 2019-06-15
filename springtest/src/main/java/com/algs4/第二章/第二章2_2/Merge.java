package com.algs4.第二章.第二章2_2;


import static com.algs4.第二章.第二章2_1.Template.less;

/**
 * @Author: czw
 * @CreateTime: 2019-06-14 13:37
 * @UpdeteTime: 2019-06-14 13:37
 * @Description:
 */
public class Merge {
	private static Comparable[] aux;//归并所需的辅助数组
	public static void sort(Comparable[] a){
		aux=new Comparable[a.length];//一次性分配空间
		sort(a,0,a.length-1);
	}
	public static void sort(Comparable[] a,int lo,int hi){
		//将数组a[lo..hi]排序
		if (hi<=lo)
			return;
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	public static void merge(Comparable[] a, int lo, int mid, int hi)
	{ // 将a[lo..mid] 和 a[mid+1..hi] 归并
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) // 将a[lo..hi]复制到aux[lo..hi]
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++) // 归并回到a[lo..hi]
			if (i > mid) a[k] = aux[j++];
			else if (j > hi ) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
	}

	public static void main(String[] args) {
		Comparable[] a=new Integer[10];
		for (int i=0;i<a.length;i++)
			a[i]=(int) (Math.random()*10);
		sort(a);
	}
}
