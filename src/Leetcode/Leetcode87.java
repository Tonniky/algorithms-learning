package Leetcode;

public class Leetcode87 {
    public boolean isScramble(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = char1[i] == char2[j];
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for(int k = 1; k <= len - 1; k++) {
                        if(dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        if(dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }

    public static void main(String[] args) {
        Leetcode87 out = new Leetcode87();
        String s1 = "great";
        String s2 = "rgeat";
        boolean flag = out.isScramble(s1, s2);
        System.out.print(flag);
    }
    }
