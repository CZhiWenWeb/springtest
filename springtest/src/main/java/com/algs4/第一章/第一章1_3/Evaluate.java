package com.algs4.第一章.第一章1_3;

import java.util.Stack;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-22 10:41
 * @UpdeteTime: 2019-05-22 10:41
 * @Description:
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        String ss = "(1+(2*3))";
        for (int i = 0; i < ss.length(); i++) {
            // 读取字符，如果是运算符则压入栈
            String s = String.valueOf(ss.charAt(i));
            if (s.equals("(")) ;
            else if (s.equals(" "));
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                // 如果字符为 ")"，弹出运算符和操作数，计算结果并压入栈
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            // 如果字符既非运算符也不是括号，将它作为 double 值压入栈
            else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}
