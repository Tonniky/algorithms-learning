package interviewCompany.Huawei.aTypeCode;

public class fama6 {
    public static void main(String[] args) {

        int n = 5;
        int[] m = {};
        int[] x = {};

        System.out.println(getResult(n, m, x));

    }

    private static int getResult(int n, int[] m, int[] x) {
        int bag = 0;

        for (int i = 1; i <= n; i++) {
            bag += m[i] * x[i];
        }

        boolean[] dp = new boolean[bag + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = bag; j >= m[i]; j--) {
                for (int k = 1; k <= x[i]; k++) {
                    if (j >= m[i] * k) {
                        if (dp[j - m[i] * k])
                            dp[j] = true;
                    }
                }
            }
        }

        int count = 0;
        for (boolean flag: dp) {
            if (flag) count++;
        }
        return count;
    }
}
