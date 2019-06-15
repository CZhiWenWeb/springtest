package com.algs4.第二章.第二章2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @Author: czw
 * @CreateTime: 2019-06-13 14:56
 * @UpdeteTime: 2019-06-13 14:56
 * @Description:
 */
public class Selection
{
	private final Double[] a;
	public Selection() {
		System.out.println("111111");
		int N=1000000;
		Double[] temp=new Double[N];
		for(int i=0;i<N;i++)
			temp[i]= StdRandom.uniform(0.0,100*1.0);
		this.a=temp;
	}

	public static void sort(Comparable[] a)
	{
		Stopwatch stopwatch=new Stopwatch();
		int N=a.length;
		for (int i=0;i<N;i++)
		{
			int min=i;
			for (int j=i+1;j<N;j++)
				if (less(a[j],a[min])) min=j;
			exch(a,i,min);
		}
		System.out.println(stopwatch.elapsedTime());
	}


	private static boolean less(Comparable v,Comparable w)
	{ return v.compareTo(w)<0;}

	private static void exch(Comparable[] a,int i,int j)
	{
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}

	private static void show(Comparable[] a)
	{
		for (int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}


	private static void showAnimation(Comparable[] a)
	{
		StdDraw.setXscale(0.0,a.length);
		StdDraw.setYscale(0.0,a.length);
		StdDraw.setPenRadius(0.005);
		StdDraw.pause(100);
		StdDraw.clear(StdDraw.GRAY);
		StdDraw.setPenColor(StdDraw.BLACK);
		for(int i=0;i<a.length;i++)
		{
			StdDraw.line(i*1.0,0.0,i*1.0,(Double)a[i]*1.0);
		}
	}
	public static boolean isSorted(Comparable[] a)
	{
		for (int i=0;i<a.length;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	public static void main(String[] args)
	{
		Selection selection=new Selection();
		Double[] temp=selection.a;
		Double[] temp1=selection.a;
		T214.sort(temp1);
		sort(temp);
	}
}
