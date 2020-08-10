package Leetcode;

public class circularArrayLoop457 {

    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) continue;
            int dir = nums[i] > 0 ? 1 : -1;
            if (dfs(nums, i, len, dir)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int[] nums, int i, int len, int dir) {
        if (nums[i] == 0) return false;
        if(nums[i] == Integer.MAX_VALUE) return true;
        int ndir = nums[i] > 0 ? 1 :-1;
        if (ndir == dir) {
            int j = (len + (nums[i] + i) % len) % len;
            nums[i] = Integer.MAX_VALUE;
            if ( j != i && dfs(nums, j, len, dir)) {
                return true;
            } else {
                nums[i] = 0;
                return false;
            }
        }
        return false;
    }


};
