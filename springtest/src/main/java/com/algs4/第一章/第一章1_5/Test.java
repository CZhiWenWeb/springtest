package com.algs4.第一章.第一章1_5;

import edu.princeton.cs.algs4.StdOut;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-10 14:20
 * @UpdeteTime: 2019-06-10 14:20
 * @Description:
 */
public class Test {
	public static void main(String[] args) throws IOException {
		String filePath="src/第一章1_5/tinyUF.txt";
		ArrayList<int[]> ints=getInts(filePath);
		//初始化分量id数组
		T1513 t=new T1513(16);
		for (int[] a:ints
		     ) {
			StdOut.printf("p=%d q=%d\n",a[0],a[1]);
			t.union(a[0],a[1]);
		}
		boolean b=t.connected(0,1);
		Object[] params=new Object[3];
		params[0]=t.getClass().toString();
		params[1]=b;
		out(params);
	}
	public static void out(Object[] params){
		String pattern="使用{0}，connected:{1},访问数组次数：{2}";
		MessageFormat mf=new MessageFormat(pattern);
		String content=mf.format(params);
		System.out.println(content);
	}
	public static ArrayList<int[]> getInts(String filePath) throws IOException {
		File file=new File(filePath);
		ArrayList<int[]> ints=new ArrayList<>();
		if (file.isFile()&&file.exists()){
			InputStreamReader read=new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader=new BufferedReader(read);
			String line=null;
			while ((line=bufferedReader.readLine())!=null){
				String[] s=line.split(" ");
				int[] a=new int[s.length];
				for (int i=0;i<a.length;i++){
					a[i]= Integer.valueOf(s[i]);
				}
				ints.add(a);
			}
		}
		return ints;
	}
}
