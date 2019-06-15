package com.algs4.Utils;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @Author: czw
 * @CreateTime: 2019-06-11 16:57
 * @UpdeteTime: 2019-06-11 16:57
 * @Description:
 */
public class RandomBag<Item> implements Iterable<Item>
{
	private Item[] a=(Item[]) new Object[1];
	private int N=0;

	public RandomBag()
	{
	}

	public boolean isEmpty()
	{
		return N==0;
	}

	public int size()
	{
		return N;
	}

	public void add(Item item)
	{
		if(N==a.length) resize(2*N);
		a[N]=item;
		N++;
	}

	private void resize(int max)
	{
		Item[] temp=(Item[]) new Object[max];
		for(int i=0;i<N;i++)
			temp[i]=a[i];
		a=temp;
	}

	public Iterator<Item> iterator()  {return new ListIterator();}

	private class ListIterator implements Iterator<Item>
	{

		private int index;
		public ListIterator()
		{
			for (int i = 0; i < N; i++)
			{
				int r = i + StdRandom.uniform(N-i);     // between i and n-1
				Item temp = a[i];
				a[i] = a[r];
				a[r] = temp;
			}
		}
		public boolean hasNext(){return index!=N;}
		public void remove(){}
		public Item next()
		{
			Item item=a[index];
			index++;
			return item;
		}//end next
	}//end class ListIterator

	public static void main(String[] args) {
		RandomBag<Integer> randomBag=new RandomBag<>();
		for (int i=0;i<5;i++){
			randomBag.add(i);
		}
		Iterator<Integer> integer=randomBag.iterator();
		while (integer.hasNext()){
			System.out.println(integer.next());;
		}
	}
}

