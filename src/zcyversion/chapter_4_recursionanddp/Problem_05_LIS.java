package zcyversion.chapter_4_recursionanddp;

public class Problem_05_LIS {

	public static int[] lis1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getdp1(arr);
		return generateLIS(arr, dp);
	}

	public static int[] getdp1(int[] arr) {
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;								           //最主要的是写出dp[0]的情况。
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);		   //然后暴力解法
				}
			}
		}
		return dp;
	}

	public static int[] generateLIS(int[] arr, int[] dp) {
		int len = 0;
		int index = 0;
		for (int i = 0; i < dp.length; i++) {		//
			if (dp[i] > len) {
				len = dp[i];   //找到最长的长度
				index = i;     //将该序号保留出来
			}
		}
		int[] lis = new int[len];
		lis[--len] = arr[index];
		for (int i = index; i >= 0; i--) {
			if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {    //暴力拆解
				lis[--len] = arr[i];
				index = i;
			}
		}
		return lis;
	}

	public static int[] lis2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getdp2(arr);
		return generateLIS(arr, dp);
	}

	public static int[] getdp2(int[] arr) {
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		ends[0] = arr[0];
		dp[0] = 1;
		int right = 0;
		int l = 0;
		int r = 0;
		int m = 0;
		for (int i = 1; i < arr.length; i++) {		//
			l = 0;
			r = right;
			while (l <= r) {
				m = (l + r) / 2;
				if (arr[i] > ends[m]) {	            //二分法
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			right = Math.max(right, l);             //math使用的是
			ends[l] = arr[i];
			dp[i] = l + 1;
		}
		return dp;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		printArray(arr);
		printArray(lis1(arr));
		printArray(lis2(arr));

	}
}