package com.algs4.第一章.第一章1_5;

import java.io.IOException;
import java.util.ArrayList;

import static com.algs4.第一章.第一章1_5.Test.getInts;


/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-10 11:15
 * @UpdeteTime: 2019-06-10 11:15
 * @Description:
 */
public class WeightedQuickUnionUF {
	private int[] id;//父链接数组
	private int[] sz;//各个根节点所对应的分量的大小
	private int count;//联通分量的数量

	public WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++)
			sz[i] = 1;
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p) {
		while (p!=id[p])
			p=id[p];
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		//将小树的根节点连接到大树的根节点
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

	public static void main(String[] args) throws IOException {
		String filePath = "src/第一章1_5/tinyUF.txt";
		ArrayList<int[]> ints = getInts(filePath);
		//初始化分量id数组
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
		for (int[] a : ints
		) {
			uf.union(a[0], a[1]);
		}
		System.out.println(uf.connected(7, 6));
	}
}
