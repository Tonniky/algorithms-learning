package Leetcode;

import java.util.Stack;

public class Leetcode334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int  max = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
            max = Math.max(max, stack.size());
        }
        return max >= 3;
    }
    }
