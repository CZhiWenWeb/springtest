package com.algs4.第二章.第二章2_1;

/**
 * @Author: czw
 * @CreateTime: 2019-06-14 09:47
 * @UpdeteTime: 2019-06-14 09:47
 * @Description:
 */
public class IntTemplate {
	public static boolean less(int a,int b){
		return a<b;
	}
	public static void exch(int[] ints,int i,int j){
		int temp=ints[i];
		ints[i]=ints[j];
		ints[j]=temp;
	}
	public static void show(int[] a){
		for (int i=0;i<a.length;i++)
			System.out.print(a[i]);
		System.out.println();
	}
	public static boolean isSort(int[] a){
		for (int i=0;i<a.length-1;i++){
			if (less(a[i+1],a[i]))
				return false;
		}
		return true;
	}
}
