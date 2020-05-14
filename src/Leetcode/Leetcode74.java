package Leetcode;

public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int col = matrix.length;
        if (col == 0) {
           return false;
        }
        int row = matrix[0].length;
        int i = 0;
        for ( ; i < col; i++) {
            for (int j = row - 1; j >= 0; j--) {
                if (target == matrix[i][j]) {
                   return true;
                } else if (target > matrix[i][j]) {
                    j = 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode74 out = new Leetcode74();
        int[][] res = {{1},{3}};
        out.searchMatrix(res, 3);
    }
    }
