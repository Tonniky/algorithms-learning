package Leetcode;

import java.util.Stack;

public class Leetcode300 {

    public int lengthOfLIS1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if(len == 1) {
            return 1;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxLen = 0;
        while (i < len) {
            while(!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
            maxLen = Math.max(maxLen, stack.size());
        }
        return maxLen;
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

    }
