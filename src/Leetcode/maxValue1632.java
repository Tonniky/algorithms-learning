package Leetcode;

public class maxValue1632 {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row == 0 || col == 0) {
            return 0;
        }
        int[][] res = new int[row][col];
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += grid[i][0];
            res[i][0] = sum;
        }
        sum = 0;
        for (int j = 0; j < col; j++) {
            sum += grid[0][j];
            res[0][j] = sum;
        }
        if (col == 1 || row == 1) {
            return Math.max(res[row - 1][0], res[0][col - 1]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                res[i][j] = Math.max(res[i - 1][j],res[i][j - 1]) + grid[i][j];
            }
        }
        return res[row - 1][col - 1];
    }
}
