package Leetcode;

public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length== 0)
            return;
        int len = nums.length;
        int zero = 0;
        int left = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] == 0)
                zero++;
            if(nums[i] != 0) {
                nums[left++] = nums[i];
            }
        }
        while(zero-- > 0) {
            nums[--len] = 0;
        }
    }
    }
