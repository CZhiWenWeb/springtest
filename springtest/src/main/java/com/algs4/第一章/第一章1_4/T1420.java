package com.algs4.第一章.第一章1_4;

/**
 * @Author: chenzhiwen
 * @CreateTime: 2019-06-05 09:50
 * @UpdeteTime: 2019-06-05 09:50
 * @Description: 双调查找
 */
public class T1420 {
	public static boolean find(int[] a, int num) {
		int maxIndex = max(a);
		int head1 = 0;
		int last1 = maxIndex;
		int head2 = maxIndex + 1;
		int last2 = a.length - 1;
		int mid = 0;
		while (head1 < last1) {
			mid = (head1 + last1) / 2;
			if (a[mid] > num) {
				last1 = mid - 1;
			} else if (a[mid] < num) {
				head1 = mid + 1;
			} else {
				return true;
			}
		}
		if (a[head1] == num) {
			return true;
		}
		while (head2 < last2) {
			mid = (head2 + last2) / 2;
			if (a[mid] > num) {
				head2 = mid + 1;
			} else if (a[mid] < num) {
				last2 = mid - 1;
			} else {
				return true;
			}
		}
		if (a[head2] == num) {
			return true;
		}
		return false;
	}

	public static int max(int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		int mid;
		while (lo < hi) {
			mid = (lo + hi) / 2;
			if (a[mid] < a[mid + 1])
				lo = mid + 1;
			else if (a[mid] > a[mid + 1])
				hi = mid;
		}
		return lo;
	}

	public static void main(String[] args) {
		int[] bitonicArray = {2, 3, 4, 5, 6, 100, 89, 9, 8, 1};
		int[] a = {1, 6, 4, 3, 2};
		System.out.println(find(bitonicArray, 99));
	}
}
