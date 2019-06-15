package com.algs4.第一章.第一章1_4;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-04 15:49
 * @UpdeteTime: 2019-06-04 15:49
 * @Description:
 */
public class ThreeSumQuick {
    public static void main(String[] args) {
        int[] a={-1,-2,-3,2,1,3,4,5,-6};
        ThreeSumQuick threeSumQuick=new ThreeSumQuick();
        threeSumQuick.count(a);
    }
    public void count(int[] a){
        int count=0;
        for (int i=0;i<a.length;i++){
            int head=i+1;int last=a.length-1;
            while (head<last){
                int sum=a[i]+a[head]+a[last];
                if (sum==0){
                    System.out.println(a[i]+" "+a[head]+" "+a[last]);
                    count++;
                    break;
                }else if (sum>0){
                    last--;
                }else{
                    head++;
                }
            }
        }
    }

}
