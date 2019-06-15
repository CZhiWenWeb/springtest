package com.algs4.第一章.第一章1_5;

/**
 * @Author: czw
 * @CreateTime: 2019-06-11 15:15
 * @UpdeteTime: 2019-06-11 15:15
 * @Description:
 */
public class T1517 {
	private int n;//初始数
	private int[] id;
	private int[] sz;
	private int count;
	public T1517(int N){
		n=N;
		count=N;
		id=new int[N];
		sz=new int[N];
		for (int i=0;i<id.length;i++)
			id[i]=i;
		for (int i=0;i<sz.length;i++)
			sz[i]=1;
	}
	//从数组随机获取两个数
	public int[] randomTwoInt(){
		int[] randomInts=new int[2];
		randomInts[0]= (int) (0+Math.random()*(id.length));
		int temp;
		while ((temp=(int) (Math.random()*(id.length-1-0+1)))!=randomInts[0])
			randomInts[1]=temp;
		System.out.println(randomInts[0]+" "+randomInts[1]);
		return randomInts;
	}
	//获取根节点
	public int find(int p){
		while (p!=id[p])
			p=id[p];
		int root=p;
		return root;
	}
	//连接两个数
	public void union(int p,int q){
		int i=find(p);
		int j=find(q);
		if (i==j)
			return;
		if (sz[i]>sz[j]){
			id[j]=i;
			sz[i]+=sz[j];
		}else {
			id[i]=j;
			sz[j]+=sz[i];
		}
		count--;
		System.out.println("p:"+p+"  "+"q:"+q);
		for (int k=0;k<id.length;k++)
			System.out.print(id[k]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		T1517 t=new T1517(2);
		while (t.count>0){
			int[] is=t.randomTwoInt();
			t.union(is[0],is[1]);
		}
	}
}
