package Leetcode;

public class maxProductPath5521 {
    public int maxProductPath(int[][] grid) {
        if (grid == null) {
            return -1;
        }
        int col = grid.length;
        int row = grid[0].length;
        long mod = (long) (1e9 + 7);
        long[][][] dp = new long[col][row][2];
        dp[0][0][0] = dp[0][0][1] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[i][0][0] = dp[i][0][1] = dp[i - 1][0][0] * grid[i][0];
        }
        for (int j = 1; j < row; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j - 1][0] * grid[0][j];
        }

        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                long mina = dp[i - 1][j][0] * grid[i][j];
                long maxa = dp[i - 1][j][1] * grid[i][j];
                long minb = dp[i][j - 1][0] * grid[i][j];
                long maxb = dp[i][j - 1][1] * grid[i][j];

                dp[i][j][0] = Math.max(Math.max(mina,maxa), Math.max(minb, maxb));
                dp[i][j][1] = Math.min(Math.min(mina,maxa), Math.min(minb, maxb));
            }
        }
        long res = Math.max(dp[col - 1][row - 1][0],dp[col - 1][row - 1][1]);
        return res % mod < 0 ? -1 : (int) (res % mod);
    }

    public static void main(String[] args) {
        int[][] in = {{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}};
        maxProductPath5521 test = new maxProductPath5521();
        test.maxProductPath(in);
    }
    }
