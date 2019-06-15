package com.algs4.第二章.第二章2_1;


import static com.algs4.第二章.第二章2_1.Template.exch;
import static com.algs4.第二章.第二章2_1.Template.less;

/**
 * @Author: czw
 * @CreateTime: 2019-06-13 10:00
 * @UpdeteTime: 2019-06-13 10:00
 * @Description:
 */
public class Shell {
	public static void sort(Comparable[] a){
		int N=a.length;
		int h=1;
		while (h<N/3)
			h=3*h+1;
		while (h>=1){
			//将数组变为h有序数组
			for (int i=h;i<N;i++){
				//将a[i]插入到a[i-h]，a[i-2*h]..之中
				for (int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
					exch(a,j,j-h);
			}
			h=h/3;
		}
	}

	public static void main(String[] args) {
		Integer[] integers=new Integer[6];
		for (int i=0;i<integers.length;i++) {
			integers[i]=Integer.valueOf ((int) (Math.random()*10));
		}
		sort(integers);
	}
}
