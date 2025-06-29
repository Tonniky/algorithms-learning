package interviewCompany.Huawei.bTypeCode;

import java.util.Scanner;

public class guangfudianzhan11 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int r = in.nextInt();
//        int c = in.nextInt();
//        int s = in.nextInt();
//        int min = in.nextInt();
//
//        int[][] matrix = new int[r][c];
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                matrix[i][j] = in.nextInt();
//            }
//        }

        int r = 2;
        int c = 5;
        int s = 2;
        int min = 6;
        int[][] matrix = {{1, 3, 4, 5, 8}, {2, 3, 6, 7, 1}};

        int ans = 0;
        for (int i = s; i <= r; i++) {
            for (int j = s; j <= c; j++) {
                int square = 0;
                for (int x = i - s; x < i; x++) {
                    for (int y = j - s; y < j; y++) {
                        square += matrix[x][y];
                    }
                }
                if (square >= min) ans++;
            }
        }
        System.out.println(ans);
    }

}
