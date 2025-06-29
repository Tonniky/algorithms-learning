package interviewCompany.Huawei.bTypeCode;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Scanner;

public class allzeroOrtwoNum {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//
//        int[][] matrix = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = sc.nextInt();
//            }
//        }
//
//        matrix[0][0] = 0;

        int m = 4;
        int n = 4;
        int[][] matrix = {{0, 0, 0, 0}, {0, 2, 2, 2}, {0, 2, 0, 0}, {0, 2, 0, 0}};


        System.out.println(getNum(m, n, matrix));
    }

    public static int getResult(int m, int n, int[][] matrix) {
        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int count = 1;

        while (queue.size() > 0) {
            int[] pos = queue.removeFirst();

            int x = pos[0];
            int y = pos[1];

            for (int[] offset: offsets) {
                int newX = x + offset[0];
                int newY = y + offset[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == 0) {
                    matrix[newX][newY] = 1;
                    count++;
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return m * n - count;
    }


    public static int getResult2(int m, int n, int[][] matrix) {
        int[][] offsets = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int count = 1;
        while (!queue.isEmpty()) {
            int[] pos = queue.removeFirst();
            int xPoint = pos[0];
            int yPoint = pos[1];

            for (int[] offset: offsets) {
                int newX = xPoint + offset[0];
                int newY = yPoint + offset[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == 0) {
                    matrix[newX][newY] = 1;
                    count++;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return m * n - count;
    }


    private static int getNum(int m, int n, int[][] matrix) {
        int[][] offsets = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        matrix[0][0] = 1;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] point = queue.removeFirst();
            int xPoint = point[0];
            int yPoint = point[1];

            for (int[] offset: offsets) {
                int newX = xPoint + offset[0];
                int newY = yPoint + offset[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == 0) {
                    matrix[newX][newY] = 1;
                    queue.add(new int[]{newX, newY});
                    count++;
                }
            }
        }
        return m * n - count;
    }

}
