package interviewCompany.Huawei.bTypeCode;

import java.util.Scanner;

public class countValidStations3 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int r = in.nextInt();
//        int c = in.nextInt();
//
//        int len = in.nextInt();
//        int limit = in.nextInt();
//
//        int[][] grid = new int[r][c];
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                grid[i][j] = in.nextInt();
//            }
//        }

        int r = 2;
        int c = 5;

        int len = 2;
        int limit = 6;

        int[][] grid = {{1, 3, 4, 5, 8}, {2, 3, 6, 7, 1}};

        System.out.println(countValidStations3(grid, r, c, len, limit));
    }

    private static int countValidStations(int[][] grid, int rows, int cols, int size, int minSum) {
        int[][] prefixSum = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }

        //
        int count = 0;
        for (int i = size; i <= rows; i++) {
            for (int j = size; j <= cols; j++) {
                int sum = prefixSum[i][j] - prefixSum[i - size][j]
                        - prefixSum[i][j - size] + prefixSum[i - size][j - size];

                if (sum >= minSum) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countValidStations3(int[][] grid, int rows, int cols, int size, int minSum) {
        int[][] prefixNum = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixNum[i][j] = grid[i - 1][j - 1] + prefixNum[i][j - 1] + prefixNum[i - 1][j] + prefixNum[0][0];
            }
        }

        int count = 0;
        for (int i = size; i <= rows; i++) {
            for (int j = size; j <= cols; j++) {
                int sum = prefixNum[i][j] - prefixNum[i - size][j] - prefixNum[i][j - size] + prefixNum[i - size][j - size];

                if (sum >= minSum) {
                    count++;
                }

            }
        }
        return count;
    }


}