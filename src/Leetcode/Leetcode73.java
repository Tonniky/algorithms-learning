package Leetcode;

import java.util.HashSet;

public class Leetcode73 {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        HashSet<Integer> colZero = new HashSet<>();
        HashSet<Integer> rowZero = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    colZero.add(i);
                    rowZero.add(j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j =0; j < col; j++) {
                if(colZero.contains(i) || rowZero.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeros1(int[][] martix) {
        int row = martix.length;
        int col = martix[0].length;
        final  int UNDEFINE = -100;
        for (int i =0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (martix[i][j] == 0) {

                    for (int k = 0; k < row; k++){
                        if (martix[k][j] != 0) {
                            martix[k][j] = UNDEFINE;
                        }
                    }

                    for (int m = 0; m < col; m++) {
                        if (martix[i][m] != 0) {
                            martix[i][m] = UNDEFINE;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (martix[i][j] == UNDEFINE) {
                    martix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Leetcode73 param = new Leetcode73();

    }
    }
