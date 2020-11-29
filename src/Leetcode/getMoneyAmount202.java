package Leetcode;
import java.util.*;

public class getMoneyAmount202 {
    public int getMoneyAmount(int n) {
        return calcatute(1,n);
    }
    public int calcatute(int low, int high) {
        if(low >= high) {
            return 0;
        }
        int middle = Integer.MAX_VALUE;
        for (int i = low; i < high; i++) {
            int res = i + Math.max(calcatute(low, i - 1), calcatute(i + 1, high));
            middle = Math.min(middle, res);
        }
        return middle;
    }

    // 优化一下上面的。
    public int calcatute1(int low, int high) {
        if (low >= high) {
            return 0;
        }
        int middle = Integer.MAX_VALUE;
        for (int i = (low + high) / 2; i < high; i++) {
            int res = i + Math.max(calcatute(low, i - 1), calcatute(i + 1, high));
            middle = Math.min(middle, res);
        }
        return middle;
    }


    //dp解决问题： 时间 o（n3）
    public int getMoneyAmount1(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int middle = Integer.MAX_VALUE;
//                for (int piv = start; piv < start + len - 1; piv++)
// 改进版本
                    for (int piv = start + (len - 1) / 2; piv < start + len - 1; piv++) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    middle = Math.min(res, middle);
                }
                dp[start][start + len - 1] = middle;
            }
        }
        return dp[1][n];
    }

    }
