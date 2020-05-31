package Leetcode;

import java.util.Arrays;

public class Leetcode213 {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums,0 ,nums.length -1)), myRob(Arrays
        .copyOfRange(nums,1, nums.length)));

    }

    public int myRob(int[] nums) {
        int pre = 0, cur = 0, temp;
        for(int num : nums) {
            temp = cur;
            cur = Math.max(cur, pre + num);
            pre = temp;
        }
        return cur;
    }
    }
