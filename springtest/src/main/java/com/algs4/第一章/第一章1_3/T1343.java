package com.algs4.第一章.第一章1_3;

import java.io.File;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-01 14:53
 * @UpdeteTime: 2019-06-01 14:53
 * @Description: 文件列表
 */
public class T1343 {
    public static void main(String[] args) {
        String s="F:\\TestHTML";
        invoke(s);
    }
    public static void invoke(String s){
        System.out.println(" ");
        File file=new File(s);
        File[] files=file.listFiles();
        for (int i=0;i<files.length;i++){
            if (files[i].isDirectory()){
                System.out.println(" "+files[i].toString());
                invoke(files[i].toString());
            }else {
                System.out.println(files[i]);
            }
        }
    }
}
