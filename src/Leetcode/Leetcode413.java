package Leetcode;

public class Leetcode413 {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i -1];
                sum += dp[i];
            }
        }
        return sum;
    }

    public int numberOfArithmeticSlices1(int[] A) {
        int dp = 0;
        int sum = 0;
        int len = A.length;
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = 1 + dp;
                sum += dp;
            } else {
                dp = 0;
            }
        }
        return sum;
    }

    }
