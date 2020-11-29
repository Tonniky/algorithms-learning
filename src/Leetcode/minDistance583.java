package Leetcode;
import java.util.*;
public class minDistance583 {

    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        return s1.length() + s2.length() - 2 * lcs(s1, s2, m, n);
    }

    public int lcs(String s1, String s2, int m, int n) {
        if(m == 0 || n ==0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        }
        return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    }

    public int minDistance2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dis = new int[m + 1][n + 1];
        return m + n - 2 * lcs2(s1, s2, m, n, dis);
    }

    public int lcs2(String s1, String s2, int m, int n, int[][] dis) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dis[m][n] > 0) {
            return dis[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs2(s1, s2, m - 1, n - 1, dis);
        } else
            Math.max(lcs2(s1, s2, m, n - 1, dis), lcs2(s1, s2, m - 1, n, dis));
        return dis[m][n];
    }

    public int minDistance3(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j ==0)
                    continue;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }


    public int minDistance4(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dis = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (m == 0 || n ==0) {
                    dis[i][j] = i + j;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dis[i][j] = dis[i - 1][j -1];
                } else {
                    dis[i][j] = 1 + Math.min(dis[i][j - 1], dis[i - 1][j]);
                }
            }
        }
        return dis[m][n];
    }

    }
