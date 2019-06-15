package com.algs4.第二章.第二章2_1;


import static com.algs4.第二章.第二章2_1.Template.less;
import static com.algs4.第二章.第二章2_1.Template.show;

/**
 * @Author: czw
 * @CreateTime: 2019-06-12 15:54
 * @UpdeteTime: 2019-06-12 15:54
 * @Description:n-1次交换的插入排序
 */
public class Insertion{
	public static void sort(Comparable[] a) {
		int N=a.length;
		for (int i=1;i<N;i++){
			Comparable temp=a[i];
			int index=i;
			for (int j=i;j>0&&less(a[j],a[j-1]);j--){
				a[j]=a[j-1];
				a[j-1]=temp;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] integers=new Integer[10];
		for (int i=0;i<integers.length;i++)
			integers[i]=Integer.valueOf((int) (Math.random()*10));
		Insertion.sort(integers);
		show(integers);
	}
}
