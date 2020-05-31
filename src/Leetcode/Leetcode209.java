package Leetcode;

public class Leetcode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        if ( nums == null) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }
        }
        return ans = ans == Integer.MAX_VALUE ? 0 : ans;
    }
    }
