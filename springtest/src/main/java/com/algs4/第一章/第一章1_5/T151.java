package com.algs4.第一章.第一章1_5;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-10 13:43
 * @UpdeteTime: 2019-06-10 13:43
 * @Description:扫描数组
 */
public class T151 {
	private int[] ids;
	private int N;
	private int count;

	public int getCount() {
		return count;
	}

	public T151(int N){
		this.ids=new int[N];
		for (int i=0;i<ids.length;i++)
			ids[i]=i;
		this.N=N;
	}
	public int find(int p){
		count++;
		return ids[p];
	}
	public void union(int p,int q){
		int m=find(p);
		int n=find(q);
		if (m==n)
			return;
		for (int i=0;i<ids.length;i++){
			count++;
			if (ids[i]==n){
				count++;
				ids[i]=m;
			}
		}
		N--;
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
}
