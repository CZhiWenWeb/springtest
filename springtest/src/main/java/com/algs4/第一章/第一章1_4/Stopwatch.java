package com.algs4.第一章.第一章1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ThreeSum;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-01 17:20
 * @UpdeteTime: 2019-06-01 17:20
 * @Description:计时器
 */
public class Stopwatch {
    private final long start;
    public Stopwatch()
    { start = System.currentTimeMillis(); }
    public double elapsedTime()
    {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
    public static void main(String[] args)
    {
        int N = Integer.parseInt("1000");
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-1000000, 1000000);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + " triples " + time + " seconds");
    }
}
