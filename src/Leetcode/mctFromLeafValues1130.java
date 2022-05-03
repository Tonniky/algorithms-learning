package Leetcode;

import java.util.Stack;

public class mctFromLeafValues1130 {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (stack.peek() <= arr[i] || i == n - 1)) {
                int bottom = stack.pop();
                if (!stack.isEmpty()) {
                    res += Math.min(stack.peek(), arr[i]) * bottom;
                } else {
                    res += bottom * arr[i];
                }
                arr[i] = Math.max(bottom, arr[i]);
            }
            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        mctFromLeafValues1130 mctFromLeafValues1130 = new mctFromLeafValues1130();
        mctFromLeafValues1130.mctFromLeafValues2(new int[]{6,2,4});
    }

    public int mctFromLeafValues2(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] maxVal = new int[n][n];

        for (int i = 0; i < n; i++) {
            maxVal[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                maxVal[i][j] = Math.max(maxVal[i][j - 1], arr[j]);
            }
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                dp[i][i + len] = Integer.MAX_VALUE;
                for (int k = i; k < i + len; k++) {
                    dp[i][i + len] = Math.min(dp[i][i + len], dp[i][k] + dp[k + 1][i + len] + maxVal[i][k] * maxVal[k + 1][i + len]);
                }
            }
        }
        return dp[0][n - 1];
    }


}
