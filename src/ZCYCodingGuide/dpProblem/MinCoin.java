package ZCYCodingGuide.dpProblem;

public class MinCoin {

    public int minCoin (int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }

        int len = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[len][aim + 1];
        for (int i = 1; i <= aim; i++) {
            dp[0][i] = max;
            if (i - arr[0] >= 0 && dp[0][i - arr[0]] != max) {
                dp[0][i] = dp[0][i - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }


    public int minCoin2(int[] arr, int aim) {
        for (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }
        int len = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        for (int i = 1; i <= aim; i++) {
            dp[i] = max;
            if (i - arr[0] >= 0 && dp[i - aim] != max) {
                dp[i] = dp[i - aim] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
                    left = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        return dp[aim] != max ? dp[aim] : -1;
    }
}
