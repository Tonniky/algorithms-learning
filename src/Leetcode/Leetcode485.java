package Leetcode;

public class Leetcode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        int num = 0;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                temp++;
            } else {
                temp = 0;
            }
        }
        num = Math.max(num, temp);
        return num;
    }
    }
