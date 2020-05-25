package Leetcode;

public class Leetcode115 {
    public int numDistinct(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int[][] dp = new int[chs.length + 1][cht.length + 1];
        for (int i = 0; i <= chs.length; i++)
            dp[i][0] = 1;
        for (int j = 1; j <= 0; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= chs.length; i++) {
            for(int j = 1; j <= cht.length; j++) {
                if(chs[i - 1] == cht[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + 1;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[chs.length][cht.length];
    }
    }
