package Leetcode;

import java.util.Arrays;

public class Leetcode268 {
    public int missingNumber(int[] nums) {
        if (nums == null)
            return 0;
        Arrays.sort(nums);
        int i = 0;
        while(true) {
            if(i < nums.length && nums[i] != i) {
                return i;
            }
            if(i == nums.length -1) {
                return nums.length;
            }
            i++;
        }
    }


    }
