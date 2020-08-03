package Leetcode;

public class findTargetSumWays494 {
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int add = (sum - S) / 2;
        if ((sum - S) % 2 != 0) {
            return 0;
        }
        return 0;
    }

    int count = 0;
    public int findTargetSumWays1(int[] nums, int S) {
        cal(nums, 0, 0, S);
        return count;
    }

    public void cal(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
        } else {
            cal(nums, i + 1, sum + nums[i], S);
            cal(nums, i + 1, sum - nums[i], S);
        }
    }

    public int findTargetSumWays2(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum < 1000; sum++) {
                dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    public int findTargetSumWays3(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum < 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }




    }
