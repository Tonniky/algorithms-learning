package interviewCompany.Huawei.bTypeCode;

import java.util.Scanner;

public class juzheng14 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.close();

        int cols = (int) Math.ceil(n / (double) m);
        int[][] matrix = new int[m][cols];

        int num = 1;
        int top = 0, bottom = m - 1, left = 0, right = cols - 1;
        while (num <= n) {
            for (int i = left; i <= right && num <= n; i++) {
                matrix[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom && num <= n; i++) {
                matrix[i][right] = num++;
            }
            right--;

            for (int i = right; i >= left && num <= n; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            for (int i = bottom; i >= top && num <= n; i--) {
                matrix[i][left] = num++;
            }
            left++;

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println('*');
                } else {
                    System.out.println(matrix[i][j]);
                }
                if (j < cols - 1) {
                    System.out.println(" ");
                }
            }
            System.out.println();
        }
    }

}
