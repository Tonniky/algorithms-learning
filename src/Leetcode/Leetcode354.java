package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            secondDim[i] = envelopes[i][1];
        }
        return lengthOfLIS(secondDim);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1)
            return 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1; i < len; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int m : dp) {
            res = Math.max(res, m);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode354 out = new Leetcode354();
        int[][] in = {{5,4},{6,4},{6,7},{2,3}};
        out.maxEnvelopes(in);
    }
    }
