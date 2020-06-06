package Leetcode;

public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount < 0 || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int len = coins.length;
        int[][] dp = new int[len][amount + 1];
        int temp = Integer.MAX_VALUE;
        for(int i = 1; i <= amount; i++) {
            dp[0][i] = temp;
            if (i - coins[0] >= 0 && dp[0][i - coins[0]] != temp) {
                dp[0][i] = dp[0][i - coins[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= amount; j++) {
                left = temp;
                if (j - coins[i] >= 0 && dp[i][j - coins[i]] != temp) {
                    left = dp[i][j - coins[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[len - 1][amount] != temp ? dp[len - 1][amount] : -1;
    }
    }
