package hot100;

public class maxSubArray {

    public static void main(String[] args) {
        int[] num = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(num));
    }

    private static int maxSubArray(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }
        int[] dp = new int[N];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private static int maxSubArray1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
