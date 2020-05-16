package Leetcode;

import java.util.Arrays;

public class Leetcode85 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
         int[] height = new int[col];
        int maxArea = 0;
        int[] left = new int[col];
        int[] right = new int[col];
        Arrays.fill(right, col);

        for (int i = 0; i < row; i++) {

            int cur_l = 0, cur_r = col;
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }
            //left
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(cur_l,left[j]);
                } else {
                    left[j] = 0;
                    cur_l = j + 1;
                }
            }

            //right
            for (int j = col - 1; j >= 0; j--) {
                if(matrix[i][j] == '1')
                    right[j] = Math.min(cur_r,right[j]);
                else {
                    cur_r = j;
                    right[j] = col - 1;
                }
            }


            for (int j = 0; j < col; j++) {
                maxArea = Math.max(maxArea, height[j] * (right[j] - left[j]));
            }
        }
        return maxArea;
    }


    //
    public static void main(String[] args) {
        char[][] test = {{'1','0','1','1'},{'0','1','1','1'}};
        Leetcode85 out = new Leetcode85();
        out.maximalRectangle(test);
    }

    }
