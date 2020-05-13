package Leetcode;

public class Leetcode64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row == 0 || col == 0) {
            return 0;
        }
        if (row == 1 && col == 1) {
            return grid[0][0];
        }
        if (row > 1) {
            for (int i = 0; i < row; i++){
                if(i == 0)
                    continue;
                grid[i][0] += grid[i-1][0];
            }
        }
        if (col > 1) {
            for (int j = 0; j <col; j++) {
                if(j == 0)
                    continue;
                grid[0][j] += grid[0][j-1];
            }
        }
        if (row >= 2 && col >= 2) {
            grid[1][1] = Math.min(grid[0][1],grid[1][0]) + grid[1][1];
        }
        if (row >= 2 && col >= 2) {
            for (int i = 1; i < row; i++) {
                for(int j =1; j < col; j++) {
                    if (i == 1 && j ==1)
                        continue;
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] input = {{1,2},{3,2}};
        Leetcode64 res = new Leetcode64();
        res.minPathSum(input);
    }
}
