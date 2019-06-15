package com.algs4.第一章.第一章1_4;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-05 17:40
 * @UpdeteTime: 2019-06-05 17:40
 * @Description: 扔鸡蛋
 */
public class T1424 {
	public static void find(int a,int f){
		int sum=0;
		int head=1;int last=a;int mid;
		while (head<last){
			sum++;
			mid=(head+last)/2;
			if (mid>f){
				last=mid-1;
			}else if (mid<f){
				head=mid+1;
			}else {
				System.out.println(sum);
				return;
			}
		}
		System.out.println(sum);
	}
	public static void find(int a,int f,int sum){
		int count=0;
		int fn1=1;int fn=1;
		while (fn1<a&&sum>0){
			if (fn1>f){
				count++;
				sum--;
				for (int i=fn+1;i<fn1;i++){
					count++;
					if (f==i){
						System.out.println(sum);
					}
				}
			}else if (fn1<f&&(fn1+fn)<a){
				count++;
				System.out.println("fn1"+" "+fn1+" "+"fn"+" "+fn);
				fn1=fn+fn1;
				fn=fn1-fn;
			} else if (fn1<f&&(fn+fn1)>=a){
				count++;
				int head=fn1+1;int last=a;int mid;
				while (head<last){
					mid=(head+last)/2;
					if (mid>f){
						count++;
						sum--;
						for (int i=head;i<mid;i++){
							count++;
							sum--;
							System.out.println(sum);
						}
					}else if (mid<f){
						count++;
						head=mid+1;
					}else {
						count++;
						sum--;
						System.out.println(sum);
					}
				}
				if (head==f){
					count++;
					sum--;
					System.out.println(sum);
				}
			}else {
				count++;
				sum--;
				System.out.println(sum);
			}
		}
		System.out.println("count"+" "+count);
	}
	public static void main(String[] args) {
		//find(100,1);
		find(100,100,2);
	}
}
