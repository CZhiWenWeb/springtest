package com.algs4.第一章.第一章1_5;


import edu.princeton.cs.algs4.In;

import java.io.*;
import java.util.ArrayList;


/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-09 13:44
 * @UpdeteTime: 2019-06-09 13:44
 * @Description:
 */
public class UF {
	private int[] id;//分量id(以触点作为索引)
	private int count;//分量的数量
	public UF(int N){
		count=N;
		id=new int[N];
		for (int i=0;i<N;i++){
			id[i]=i;
		}
	}
	public int count(){
		return count;
	}
	public int find(int p){
		return id[p];
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	//平方级
	public void union(int p,int q){
		int pID=find(p);
		int qID=find(q);
		if (pID==qID)
			return;
		for (int i=0;i<id.length;i++){
			if (id[i]==pID){
				id[i]=qID;
			}
		}
		count--;
	}

	private int find2(int p)
	{ // 找出分量的名称
		while (p != id[p]) p = id[p];
		return p;
	}
	public void union2(int p, int q)
	{ // 将p和q的根节点统一
		int pRoot = find2(p);
		int qRoot = find2(q);
		if (pRoot == qRoot) return;
		id[pRoot] = qRoot;
		count--;
	}
}
