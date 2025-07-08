package interviewCompany.Huawei.aTypeCode;

public class LongestPattern5 {

    public static void main(String[] args) {
        String str1 = "hello123world";
        String str2 = "hello123";

        System.out.println(getMaxLength(str1, str2));
    }

    /**
     * 获取点位信息
     */
    private static String getResult(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        int max = 0;
        String ans = "";

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        ans = str1.substring(i - max, i);
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }


    private static String getMaxLength(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        int maxLen = 0;
        String ans = "";

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        ans = str1.substring(i - maxLen, i);
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }


}


