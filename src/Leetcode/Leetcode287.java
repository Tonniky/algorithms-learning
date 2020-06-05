package Leetcode;

public class Leetcode287 {
    public int findDuplicate(int[] nums) {
        int n = 1;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
            if (n == 0) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
    }
