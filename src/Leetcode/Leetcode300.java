package Leetcode;

import java.util.Stack;

public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
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

    }
