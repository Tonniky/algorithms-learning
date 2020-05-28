package Leetcode;

public class Leetcode162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (len == 2 ) {
            if (nums[0] < nums[1])
                return 1;
            return 0;
        }
        for (int i = 1; i < len - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        if(nums[len -1] > nums[0]) {
            return len - 1;
        }
        return 0;
    }

    public int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
    }
