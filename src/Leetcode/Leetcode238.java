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

    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] R = new int[len];
        int[] L = new int[len];
        int[] res = new int[len];
        L[0] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        R[len - 1] = 1;
        for (int j = len - 2; j >=0; j--) {
            R[j] = R[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }

    }
