package Leetcode;

public class Leetcode220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null) {
            return false;
        }
        int len = nums.length;
        if (len == 0 || len == 1) {
            return false;
        }
        for (int i = 0; i < len - 1; i ++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t && (j - i) <= k)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode220 out = new Leetcode220();
        int[] in = {-1, 2147483647};
        out.containsNearbyAlmostDuplicate(in, 1, 2147483647);
    }
    }
