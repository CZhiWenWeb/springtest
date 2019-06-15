package com.algs4.第二章.第二章2_1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import static com.algs4.第二章.第二章2_1.Template.exch;
import static com.algs4.第二章.第二章2_1.Template.less;

/**
 * @Author: czw
 * @CreateTime: 2019-06-13 10:58
 * @UpdeteTime: 2019-06-13 10:58
 * @Description:
 */
public class T214 {
	public static void sort(Comparable[] a){
		Stopwatch stopwatch=new Stopwatch();
		int N=a.length;
		int[] sz=new int[20];
		int maxIndex=0;
		sz[maxIndex]=1;
		while (sz[maxIndex]<N/3){
			int num=sz[maxIndex]*3+1;
			sz[++maxIndex]=num;
		}
		while (maxIndex>=0){
			for (int i=sz[maxIndex];i<N;i++){
				for (int j=i;j>=sz[maxIndex]&&less(a[j],a[j-sz[maxIndex]]);j-=sz[maxIndex]){
					exch(a,j,j-sz[maxIndex]);
				}
			}
			maxIndex--;
		}
		System.out.println(stopwatch.elapsedTime());
	}

	public static void main(String[] args) {
		//int[] ints=new int[5];
		//int index=0;ints[index]=1;
		//ints[++index]=ints[--index]+1;
		for ( int N=100;N<=10000000;N=N*10)
		{
			Double[] a=new Double[N];
			for (int i=0;i<N;i++)
				a[i]= StdRandom.uniform(100.0,100000000.0);
			sort(a);
		}

	}
}
