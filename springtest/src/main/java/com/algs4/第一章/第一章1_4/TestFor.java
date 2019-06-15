package com.algs4.第一章.第一章1_4;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-03 17:47
 * @UpdeteTime: 2019-06-03 17:47
 * @Description:
 */
public class TestFor {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            while (i>0){
                if (i==1)
                    break;
                System.out.println(i);
                i--;
            }
        }
    }
}
