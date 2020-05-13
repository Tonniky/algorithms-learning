package Leetcode;

public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(row == 0 || col == 0) {
            return 0;
        }
        if(obstacleGrid[0][0] == 1) {
            obstacleGrid[0][0] = 0;
        } else {
            obstacleGrid[0][0] = 1;
        }
        if(col > 1) {
            if (obstacleGrid[0][1] == 1) {
                obstacleGrid[0][1] = 0;
            } else {
                obstacleGrid[0][1] = obstacleGrid[0][0];
            }
        }
        if(row > 1) {
            if (obstacleGrid[1][0] == 1) {
                obstacleGrid[1][0] = 0;
            } else {
                obstacleGrid[1][0] = obstacleGrid[0][0];
            }
        }
        if(row > 2) {
            for (int i = 1; i < row; i++) {
                if(i == 1)
                    continue;
                if (obstacleGrid[i][0] == 1) {
                    obstacleGrid[i][0] = 0;
                    continue;
                }
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }
        if(col > 2) {
            for (int i = 1; i < col; i++) {
                if(i == 1)
                    continue;
                if (obstacleGrid[0][i] == 1) {
                    obstacleGrid[0][i] = 0;
                    continue;
                }
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            }
        }
        if(obstacleGrid.length == 1 || obstacleGrid.length == 1)
            return obstacleGrid[row-1][col-1];

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] data = {{0,0,0},{0,1,0},{0,0,0}};
        Leetcode63 res = new Leetcode63();
        res.uniquePathsWithObstacles(data);
    }

}
