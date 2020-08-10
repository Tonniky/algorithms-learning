package Leetcode;

import java.util.Arrays;

public class minMoves453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] - nums[0];
        }
        return sum;
    }

    public int minMoves2(int[] nums) {
        int min = 0, max = nums.length - 1, count = 0;
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[min] > nums[i]) {
                    min = i;
                }
                if (nums[min] < nums[i]) {
                    max = i;
                }
            }
            if (min == max) {
                break;
            }
            for (int i = 0; i < nums.length; i++) {
                if (max != i) {
                    nums[i]++;
                }
                count++;
            }
        }
        return count;
    }



    }
