package ZCYCodingGuide.dpProblem;

public class MinPath {

    public int minPath(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0;
        }

        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];
        for (int i = 0; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int j = 0; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }

        return dp[row - 1][col - 1];
    }
}
