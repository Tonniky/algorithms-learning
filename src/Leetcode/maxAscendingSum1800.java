package Leetcode;

public class maxAscendingSum1800 {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int len = nums.length;
        int cur = nums[0];
        int temp = cur;
        if (len == 1) {
            return cur;
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] > cur) {
                temp = temp + nums[i];
            } else {
                res = Math.max(res, temp);
                temp = nums[i];
            }
            cur = nums[i];
            if (i == len - 1) {
                return Math.max(res, temp);
            }
        }
        return res;
    }
}
