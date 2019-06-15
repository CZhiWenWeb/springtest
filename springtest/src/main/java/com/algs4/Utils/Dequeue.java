package com.algs4.Utils;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-09 09:20
 * @UpdeteTime: 2019-06-09 09:20
 * @Description: 三个栈实现的双向队列
 */
public class Dequeue<Item> {
	private Stack<Item> sLeft=new Stack<>();
	private Stack<Item> sRight=new Stack<>();
	private Stack<Item> sTemp=new Stack<>();
	boolean TemplsRight=false;//false表示中转栈存的是左栈数据，true表示右
	public boolean isEmpty(){
		return sLeft.isEmpty()&&sRight.isEmpty()&&sTemp.isEmpty();
	}
	public int size(){
		return sLeft.size()+sRight.size()+sTemp.size();
	}
	public void pushLeft(Item item){
		sLeft.push(item);
	}
	public Item popLeft() throws Exception {
		if (!sLeft.isEmpty()){
			return sLeft.pop();
		}//左栈无内容，中转栈有内容，中转栈是右栈内容时，从中转栈弹出
		else if (!sTemp.isEmpty()&&TemplsRight){
			return sTemp.pop();
		}
		//左栈无内容，中转栈有内容，中转栈时左栈内容时，把中转栈内容全部倒入左栈，然后左栈弹出
		else if (!sTemp.isEmpty()&&!TemplsRight){
			while (!sTemp.isEmpty()){
				sLeft.push(sTemp.pop());
			}
			return sLeft.pop();
		}
		//左栈无内容，中转栈无内容，右栈有内容，把右栈内容全部倒入中转栈，中转栈存入内容标记为右栈
		//从中转栈弹出
		else if (sTemp.isEmpty()&&!sRight.isEmpty()){
			while (!sRight.isEmpty()){
				sTemp.push(sRight.pop());
			}
			TemplsRight=true;
			return sTemp.pop();
		}else {
			return null;
		}
	}
	public void pushRight(Item item){
		sRight.push(item);
	}
	public Item popRight() throws Exception {
		if (!sRight.isEmpty()){
			return sRight.pop();
		}else if (!sTemp.isEmpty()&&TemplsRight){
			while (!sTemp.isEmpty()){
				sRight.push(sTemp.pop());
			}
			return sRight.pop();
		}else if (!sTemp.isEmpty()&&!TemplsRight){
			return sTemp.pop();
		}else if (sTemp.isEmpty()&&!sLeft.isEmpty()){
			while (!sLeft.isEmpty()){
				sTemp.push(sLeft.pop());
			}
			TemplsRight=false;
			return sTemp.pop();
		}else{
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		Dequeue<Integer> d=new Dequeue<>();
		d.pushLeft(1);d.pushRight(2);
		System.out.println(d.size());
		System.out.println(d.popLeft());
		System.out.println(d.popRight());
		System.out.println(d.size());
	}
}
