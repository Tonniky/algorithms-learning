package Leetcode;

public class Leetcode55 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }
        int next = 0;
        for(int i=0; i < nums.length; i++) {
            if(i <= next){
            next = Math.max(next,i + nums[i]);
            if(next == nums.length) {
                return true;
                }
            }
        }
        return false;
    }

}
