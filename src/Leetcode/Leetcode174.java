package Leetcode;

public class Leetcode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null) {
            return 0;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        for (int i = 1; i < row; i++) {
            dungeon[i][0] = dungeon[i - 1][0] + dungeon[i][0];
        }
        for (int j = 1; j < col; j++) {
            dungeon[0][j] = dungeon[0][j - 1] + dungeon[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
//                dungeon[i][j] = Math.min()
            }
        }
        return 0;
    }

    public int calculateMinimumHP1(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 1;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row--][col--];
        dp[row][col] = dungeon[row][col] > 0 ? 1 : 1 - dungeon[row][col];
        for (int i = col - 1; i >= 0; i--) {
            dp[row][i] = Math.max(dp[row][i + 1] - dungeon[row][i], 1);
        }
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(dp[i + 1][col] - dungeon[i][col], 1);
            for (int j = col - 1; j >= 0; j--) {
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] in = {{-2,-2,3},{-1,-2,-3},{0,-3,1}};
        Leetcode174 out = new Leetcode174();
        out.calculateMinimumHP1(in);
    }
    }
