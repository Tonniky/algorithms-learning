package Leetcode;

public class maxSubArray53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int tem : nums) {
            if(sum > 0) {
                sum += tem;
            } else {
                sum = tem;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
