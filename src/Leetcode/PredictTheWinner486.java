package Leetcode;

public class PredictTheWinner486 {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        if (nums.length == 2) {
            return true;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0 ? true : false;
    }

    public boolean PredictTheWinner2(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[nums.length - 1] >= 0 ? true : false;
    }

    public static void main(String[] args) {
        int[] te = {1,3,5};
        PredictTheWinner486 test = new PredictTheWinner486();
        test.PredictTheWinner2(te);
    }
    }
