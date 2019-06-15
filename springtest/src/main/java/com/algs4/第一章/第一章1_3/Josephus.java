package com.algs4.第一章.第一章1_3;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-01 10:24
 * @UpdeteTime: 2019-06-01 10:24
 * @Description:
 */
public class Josephus<Item> {
    private Node first=null;
    private int N=0;
    private Node last=null;
    private class Node{
        Item item;
        Node next;
        public Node(Item item){
            this.item=item;
        }
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int length(){
        return N;
    }
    public void push(Item item){
        Node newNode=new Node(item);
        if (isEmpty()){
            first=newNode;
            last=newNode;
            N++;
        }else {
            Node lNode=last;
            last.next=newNode;
            last=newNode;
            N++;
        }
    }
    public Item pop() throws Exception {
        if (isEmpty()){
            throw new Exception("空队列");
        }
        Node fNode=first;
        Item item=fNode.item;
        if (N==1){
            first=null;
            last=null;
            N--;
            return item;
        }else {
            Node newFirst=first.next;
            first.next=null;
            first=newFirst;
            N--;
            return item;
        }
    }

    public static void main(String[] args) throws Exception {
        Josephus<Integer> josephus=new Josephus<>();
        for (int i=0;i<7;i++){
            josephus.push(i);
        }
        while (josephus.N>1){
            Integer i=josephus.pop();
            josephus.push(i);
            Integer i2=josephus.pop();
            System.out.print(i2+" ");
        }
        System.out.println(josephus.pop());
    }
}
