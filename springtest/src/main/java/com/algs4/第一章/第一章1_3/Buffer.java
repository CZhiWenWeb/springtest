package com.algs4.第一章.第一章1_3;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-01 16:27
 * @UpdeteTime: 2019-06-01 16:27
 * @Description:文本编辑器
 */
 class Stack<Item> {
    private int N;
    private Item[] a;

    public Stack(int cap){
        a =(Item[]) new Object[cap];
    }

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0 ; i < N ; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item){
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);

        return item;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public boolean isFull(){
        return N == a.length;
    }

    public int size()
    {
        return N;
    }
}

public class Buffer
{
    private Stack<Character> leftside;
    private Stack<Character> rightside;

    public Buffer()
    {
        this.leftside = new Stack<Character>(1);
        this.rightside = new Stack<Character>(1);
    }

    public void insert(Character c)
    {
        this.leftside.push(c);
    }

    public char delete()
    {
        return this.leftside.pop();
    }

    public void left(int k)
    {
        for (int i = 0; i < k; ++i)
        {
            this.rightside.push(this.leftside.pop());
        }
    }

    public void right(int k)
    {
        for (int i = 0; i < k; ++i)
        {
            this.leftside.push(this.rightside.pop());
        }
    }

    public int size()
    {
        return this.leftside.size() + this.rightside.size();
    }

    public String getString()
    {
        while (!leftside.isEmpty())
        {
            this.rightside.push(this.leftside.pop());
        }

        return rightside.toString();
    }

    public static void main(String[] args) {
        Buffer buffer=new Buffer();
        for (int i=0;i<10;i++){
            buffer.insert((char) i);
        }
    }
}