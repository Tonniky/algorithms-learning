package Leetcode;

public class Leetcode153 {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1])
                return nums[i];
        }
        return nums[0];
    }
    }
