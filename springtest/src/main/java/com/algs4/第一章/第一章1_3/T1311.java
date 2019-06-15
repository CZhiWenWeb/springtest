package com.algs4.第一章.第一章1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-25 13:45
 * @UpdeteTime: 2019-05-25 13:45
 * @Description:
 */
public class T1311 {
    public static void main(String[] args) {
        Stack1<String> stack = new Stack1<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if      (s.equals("+")) stack.push(s);
            else if (s.equals("*")) stack.push(s);
            else if (s.equals(")")) StdOut.print(stack.pop() + " ");
            else if (s.equals("(")) StdOut.print("");
            else                    StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
