package Leetcode;

import java.util.Stack;

public class Leetcode456 {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;
        Stack<Integer>  stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.size() > 1 && stack.peek() > nums[i]) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;
        Stack<Integer>  stack = new Stack<>();
        int[] min = new int[len];
        min[0] = nums[0];
        int m = min[0];
        for (int i = 1; i < len; i++) {
            if (m > nums[i]) {
                m = nums[i];
            }
            min[i] = m;
        }
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
              int temp = stack.pop();
              if (min[i] < temp) {
                  return true;
              }
            }
            stack.push(nums[i]);
        }
        return false;
    }
    }
