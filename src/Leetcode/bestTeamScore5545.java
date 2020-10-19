package Leetcode;
import java.util.ArrayList;
import java.util.*;

public class bestTeamScore5545 {
    // 先对二维数组进行排序，然后使用dp
    public int bestTeamScore(int[] scores, int[] ages) {
        if (scores.length == 1) {
            return scores[0];
        }
        int[][] arr = new int[scores.length][2];
        int len = scores.length;
        for (int i = 0; i < len; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        // 对二维数组进行排序
        Arrays.sort(arr,new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[len];

        //赋值
        for (int i = 0; i < len; i++) {
            dp[i] = arr[i][1];
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j][1] <= arr[i][1]) {
                    dp[i] = Math.max(dp[j] + arr[i][1], dp[i]);
                }
                // 每次进行比对
            res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        bestTeamScore5545 best = new bestTeamScore5545();
        int[] scores = {1,3,5,10,15};
        int[] ages = {1,2,3,4,5};
        int ans = best.bestTeamScore(scores, ages);
    }
}
