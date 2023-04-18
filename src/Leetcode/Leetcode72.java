package Leetcode;


public class Leetcode72 {
    public int minDistance(String word1, String word2) {
        int left = word1.length();
        int right = word2.length();
        if (left * right == 0) {
            return left + right;
        }
        int[][] res = new int[left + 1][right + 1];

        for (int i = 0; i <= left; i++) {
            res[i][0] = i;
        }
        for (int j = 0; j <= right; j++) {
            res[0][j] = j;
        }

        for (int i = 1; i <= left; i++) {
            for (int j= 1; j <= right; j++) {
                int left_down_point = res[i - 1][j - 1];
                int left_point = res[i][j-1] + 1;
                int down_Point = res[i-1][j] + 1;
                if(word1.charAt(i-1) != word2.charAt(j-1)) {
                    left_down_point += 1;
                }
                res[i][j] = Math.min(left_down_point, Math.min(left_point,down_Point));
            }
        }
        return res[left][right];
    }

    public static void main(String[] args) {
        Leetcode72 output = new Leetcode72();
        output.minDistance("horse","ros");
    }
    }
