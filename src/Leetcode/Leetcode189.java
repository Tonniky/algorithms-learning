package Leetcode;

public class Leetcode189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if(k == 0) {
            return ;
        }
        int[] ne = new int[len];
        for (int i = 0; i < len; i++) {
            ne[i] = nums[i];
        }
        int m = k;
        for (int i = 0; i < k; k++) {
            nums[k] = ne[len - m];
            m--;
        }
        for (int i = k; i < len; i++) {
            nums[i] = ne[i - k];
        }
    }
    }
