package com.algs4.第一章.第一章1_3;


import edu.princeton.cs.algs4.In;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-28 09:35
 * @UpdeteTime: 2019-05-28 09:35
 * @Description:
 */
public class MyLink<Item> {
    private Node first = null;
    private int N = 0;

    private class Node<Item> {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    //返回长度
    public int length() {
        return N;
    }

    //添加节点
    public void addLink(Item item) {
        //生成节点
        Node newNode = new Node(item);
        if (first == null) {
            first = newNode;
            N++;
            return;
        }
        Node head = first;
        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
        N++;
    }

    //删除尾节点
    public void deleteLastNode() throws Exception {
        if (first == null)
            throw new Exception("空链表");
        Node head = first;
        Node curNode = first.next;
        while (curNode.next != null && curNode != null) {
            head = head.next;
            curNode = head.next;
        }
        head.next = null;
        N--;
    }

    //删除第k个元素
    public void delete(int k) throws Exception {
        if (k > N) {
            throw new Exception("越界");
        }
        Node head = first;
        Node curNode = head.next;
        if (k == 1) {
            head.next = null;
            first = curNode;
            N--;
            return;
        }
        Node lNode = null;
        while (k-- > 1) {
            lNode = head;//保存--k
            head = head.next;//保存k
            curNode = head.next;//保存k++
        }
        //让--k指向k++，k指向null
        head.next = null;
        head = curNode;
        lNode.next = head;
        N--;
    }

    //检测链表是否包含字符串key
    public boolean find(MyLink<String> myLink, String string) {
        Node node = first;
        while (node.next != null) {
            if (node.item.equals(string)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //获取int k往后的节点
    public Node get(int k) {
        Node node = first;
        while (node.next != null && --k > 0) {
            node = node.next;
        }
        return node;
    }

    //删除节点往后的元素
    public void removeAfter(Node node) {
        int sun = 0;
        Node rnode = node;
        while (node.next != null) {
            node = node.next;
            sun++;
        }
        rnode.next = null;
        N = N - sun;
    }

    //删除链表item为key的节点
    public void remove(MyLink myLink, String string) {
        Node head = myLink.first;
        while (head != null && head.item == string) {
            head = head.next;
            myLink.first.next = null;
            myLink.first = head;
            N--;
        }
        if (head == null)
            return;
        //head=myLink.first;
        Node node = head.next;
        while (node.next != null) {
            Node curNode = node.next;
            if (node.item == string) {
                node.next = null;
                head.next = curNode;
                node = curNode;
                N--;
            } else {
                head = head.next;
                node = curNode;
            }
        }
        if (node.item == string) {
            head.next = null;
            N--;
        }
    }

    //返回链表最大值
    public int max(MyLink<Integer> myLink) {
        if (myLink.first==null){
            return 0;
        }
        Node<Integer> f = myLink.first;
        int max=f.item;
        while (f.next!=null){
            Node<Integer> l=f.next;
            if (l.item>max){
                max=l.item;
            }
            f=f.next;
        }
        return max;
    }

    //测试用例
    public static void main(String[] args) throws Exception {
        MyLink myLink = new MyLink();
        for (int i = 0; i < 5; i++) {
            myLink.addLink(i);
        }

        int a=myLink.max(myLink);
    }
}
