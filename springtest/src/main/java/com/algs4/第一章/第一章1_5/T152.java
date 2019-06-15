package com.algs4.第一章.第一章1_5;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-10 14:29
 * @UpdeteTime: 2019-06-10 14:29
 * @Description:
 */
public class T152 {
	private int[] ids;
	private int[] sz;
	private int count=0;

	public int getCount() {
		return count;
	}

	public T152(int N) {
		ids = new int[N];
		for (int i = 0; i < ids.length; i++)
			ids[i] = i;
		sz = new int[ids.length];
		for (int i = 0; i < sz.length; i++)
			sz[i] = 1;
	}

	public int find(int p) {
		//获取根节点
		while (p != ids[p] && count++ != -1) {
			count++;
			p = ids[p];
		}
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		if (sz[i] < sz[j]) {
			count++;
			ids[i] = j;
			sz[j] += sz[i];
		} else {
			count++;
			ids[j] = i;
			sz[i] += sz[j];
		}
	}

}
