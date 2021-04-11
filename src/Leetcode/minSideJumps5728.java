package Leetcode;

public class minSideJumps5728 {
    public int minSideJumps(int[] obstacles) {
        int len = obstacles.length;
        int[][] dp = new int[len][3];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 1;
        for (int i = 1; i < len; i++) {
            if (obstacles[i] != 1) {
                dp[i][0] = dp[i - 1][0];
            }
            if (obstacles[i] != 2) {
                dp[i][1] = dp[i - 1][1];
            }
            if (obstacles[i] != 3) {
                dp[i][2] = dp[i - 1][2];
            }
            if (obstacles[i] != 1) {
                dp[i][0] = Math.min(dp[i][0], Math.min(dp[i][1],dp[i][2]) + 1);
            }
            if (obstacles[i] != 2) {
                dp[i][1] = Math.min(dp[i][1], Math.min(dp[i][0],dp[i][2]) + 1);
            }
            if (obstacles[i] != 3) {
                dp[i][2] = Math.min(dp[i][2], Math.min(dp[i][0],dp[i][1]) + 1);
            }
        }
        return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1],dp[len - 1][2]));
    }


    public static void main(String[] args) {
        int[] test = {0,1,2,3,0};
        minSideJumps5728 demo = new minSideJumps5728();
        int num = demo.minSideJumps(test);
    }

    public int minSideJumps1(int[] obstacles) {
        int len = obstacles.length;
        int[][] dp = new int[len][3];
        dp[0][1] = 0;
        dp[0][0] = 1;
        dp[0][2] = 1;

        for(int i=1; i<len; ++i)
        {
            if(obstacles[i] != 1) dp[i][0] = dp[i-1][0];
            if(obstacles[i] != 2) dp[i][1] = dp[i-1][1];
            if(obstacles[i] != 3) dp[i][2] = dp[i-1][2];
            if(obstacles[i] != 1) dp[i][0] = Math.min(dp[i][0], Math.min(dp[i][1], dp[i][2]) + 1);
            if(obstacles[i] != 2) dp[i][1] = Math.min(dp[i][1], Math.min(dp[i][0], dp[i][2]) + 1);
            if(obstacles[i] != 3) dp[i][2] = Math.min(dp[i][2], Math.min(dp[i][0], dp[i][1]) + 1);

        }
        return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1],dp[len - 1][2]));
    }
    }
