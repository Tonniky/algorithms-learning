package interviewCompany.Huawei.aTypeCode;

public class chengfama7 {

    public static void main(String[] args) {

        int n = 2;
        int[] m = {0, 1, 2};
        int[] x = {0, 2, 1};
        System.out.println(getResult(n, m, x));
    }

    public static int getResult(int n, int[] m, int[] x) {
        int bag = 0;
        for (int i = 1; i <= n; i++)
            bag += m[i] * x[i];

        boolean[] dp = new boolean[bag + 1];

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
            if (flag)
                count++;
        }
        return count;
    }
}
