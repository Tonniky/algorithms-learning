package Leetcode;

public class Leetcode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        Leetcode97 out = new Leetcode97();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        out.isInterleave(s1,s2,s3);
    }
}
