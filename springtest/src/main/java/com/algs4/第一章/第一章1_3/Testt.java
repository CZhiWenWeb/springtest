package com.algs4.第一章.第一章1_3;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-05-23 11:50
 * @UpdeteTime: 2019-05-23 11:50
 * @Description:
 */
public class Testt {
    public static void main(String[] args) {
        Stack1<String> integerStack = new Stack1<>();
        Stack1<String> stringStack = new Stack1<>();
        String s = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        for (int i = 0; i < s.length(); i++) {
            if (isDigit(s.charAt(i))) {
                integerStack.push(String.valueOf(s.charAt(i)));
            } else if (isOpeartor(s.charAt(i))) {
                stringStack.push(String.valueOf(s.charAt(i)));
            } else if (")".equals(String.valueOf(s.charAt(i)))) {
                if (integerStack.iterator().hasNext()) {
                    String i1 = integerStack.pop();
                    String i2 = integerStack.pop();
                    String s1 = stringStack.pop();
                    String joint = "(" +" "+i2 + " "+s1 +" "+ i1 + " "+")";
                    i = i + 2;
                    if ("*".equals((String.valueOf(s.charAt(i))))) {
                        String joint2 = "(" +" "+ joint +" "+ "*";
                        stringStack.push(joint2);
                    } else {
                        i = i - 2;
                        stringStack.push(joint);
                    }
                }else {
                    stringStack.push(")");
                }
            }
        }

        Stack1<String> stack=new Stack1<>();
        while (stringStack.iterator().hasNext()){
            stack.push(stringStack.pop());
        }
        for (String s2:stack
             ) {
            System.out.print(s2+" ");
        }
    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static boolean isOpeartor(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
