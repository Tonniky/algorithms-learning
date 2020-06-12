package Leetcode;

public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int tatget = sum / 2;
        if (sum % 2 != 0) {
            return false;
        }

        boolean[][] dp = new boolean[len][tatget + 1];
        if (nums[0] <= tatget) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= tatget; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j == nums[i]) {
                    dp[i][j] = true;
                    continue;
                }
                if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len - 1][tatget];
    }

    public boolean canPartition1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int tatget = sum / 2;
        if (sum % 2 != 0) {
            return false;
        }

        boolean[] dp = new boolean[tatget + 1];
        dp[0] = true;
        if (nums[0] <= tatget) {
            dp[nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = tatget; j >= nums[i]; j--) {
                if (j == nums[i]) {
                    dp[j] = true;
                    continue;
                }
                    dp[j] = dp[j] || dp[j - nums[i]];

            }
        }
        return dp[tatget];
    }
    }
