package com.algs4.第一章.第一章1_5;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: czw
 * @CreateTime: 2019-06-11 09:38
 * @UpdeteTime: 2019-06-11 09:38
 * @Description:只修改根节点指向
 */
public class T1513{
	private int[] id;
	private int[] sz;
	private int count;
	public T1513(int N){
		count=N;
		id=new int[N];
		sz=new int[N];
		for (int i=0;i<id.length;i++)
			id[i]=i;
		for (int i=0;i<sz.length;i++)
			sz[i]=1;
	}
	public int count(){
		return count;
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	public int find(int p){
		//找到根节点
		while (p!=id[p])
			p=id[p];
		int root=p;
		return root;
	}
	public void union(int p,int q){
		int i=find(p);
		int j=find(q);
		if (i==j)
			return;
		//修改根节点指向
		if (sz[i]<sz[j]){
			id[i]=j;
			sz[j]+=sz[i];
		}else {
			id[j]=i;
			sz[i]+=sz[j];
		}
		count--;
		for (int k=0;k<id.length;k++)
			StdOut.printf("%3d",id[k]);
		StdOut.println();
	}
}