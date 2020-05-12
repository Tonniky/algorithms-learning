package Leetcode;

public class Leetcode62 {

    public int uniquePaths(int m, int n) {
        if(m == 0 || n ==0) {
            return 0;
        }
        if(m == 1 || n ==1) {
            return 1;
        }
        int[][] score = new int[n][m];
        for(int i = 0; i < n ; i++) {
            score[i][0] = 1;
        }
        for(int j = 0; j < m; j++) {
            score[0][j] = 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                score[i][j] = score[i-1][j] + score[i][j-1];
            }
        }
        return score[n-1][m-1];
    }

    public static void main(String[] args) {
        Leetcode62 res = new Leetcode62();
        res.uniquePaths(3,2);
    }


}
