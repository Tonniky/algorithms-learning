package Leetcode;

public class Leetcode304 {
    class NumMatrix {
        private int[][] m;
        public NumMatrix(int[][] matrix) {
            m = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j ++) {
                    sum += m[i][j];
                }
            }
            return sum;
        }
    }
}
