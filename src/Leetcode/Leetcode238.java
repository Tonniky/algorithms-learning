package Leetcode;

public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = 1;
            for (int j = 0; j < len; j++) {
                if( i == j)
                    continue;
                temp *= nums[j];
            }
            res[i] = temp;
        }
        return res;
    }
    }
