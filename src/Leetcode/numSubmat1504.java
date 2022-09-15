package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class numSubmat1504 {

    public int numSubmat1(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] row = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else if (mat[i][j] != 0) {
                    row[i][j] = row[i][j - 1] + 1;
                } else {
                    row[i][j] = 0;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int col = row[i][j];
                for (int k = i; k >= 0 && col != 0; k--) {
                    col = Math.min(col, row[k][j]);
                    res += col;
                }
            }
        }
        return res;
    }

    public int numSubmat(int[][] mat) {
        //
        int n = mat.length;
        int m = mat[0].length;
        int[][] row = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j == 0) {
                    row[i][j] = mat[i][j]; //
                } else if (mat[i][j] != 0) {
                    row[i][j] = row[i][j - 1] + 1;
                } else {
                    row[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int col = row[i][j];
                for (int k = i; k >= 0 && col != 0; --k) {
                    col = Math.min(col, row[k][j]);
                    ans += col;
                }
            }
        }
        return ans;
    }

    public int numSubmat2(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] col = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    col[i][j] = mat[i][j];
                } else if (mat[i][j] != 0) {
                    col[i][j] = mat[i][j - 1] + 1;
                } else {
                    col[i][j] = 0;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = col[i][j];
                for (int k = i; k >= 0 && temp != 0; k--) {
                    temp = Math.min(temp, col[k][j]);
                    res += temp;
                }
            }
        }
        return res;
    }

    public int numSubmat4(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] row = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else if (mat[i][j] != 0) {
                    row[i][j] = row[i][j - 1] + 1;
                } else {
                    row[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < m; ++j) {
            int i = 0;
            Deque<int[]> Q = new LinkedList<int[]>();
            int sum = 0;
            while (i <= n - 1) {
                int height = 1;
                while (!Q.isEmpty() && Q.peekFirst()[0] > row[i][j]) {
                    // 弹出的时候要减去多于的答案
                    sum -= Q.peekFirst()[1] * (Q.peekFirst()[0] - row[i][j]);
                    height += Q.peekFirst()[1];
                    Q.pollFirst();
                }
                sum += row[i][j];
                ans += sum;
                Q.offerFirst(new int[]{row[i][j], height});
                i++;
            }
        }
        return ans;
    }

    public int numSubmat5(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] row = new int[n][m];
        for (int i = 0;  i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else if (mat[i][j] != 0) {
                    row[i][j] = mat[i][j - 1] + 1;
                } else {
                    row[i][j] = 0;
                }
            }
        }

        int ans = 0;
        return ans;
    }



    public static void main(String[] args) {
        numSubmat1504 numSubmat1504 = new numSubmat1504();
        numSubmat1504.numSubmat2(new int[][]{{0,1,1,0},{0,1,1,1},{1,1,1,0}});
    }

}
