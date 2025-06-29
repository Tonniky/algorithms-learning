package interviewCompany.Huawei.bTypeCode;

import java.util.Arrays;
import java.util.Scanner;

public class pisa8 {

    static int n;
    static int[] a;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        dp = new int[n][n];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, allocation((i + 1) % n, (i + n - 1) % n) + a[i]);
        }
        System.out.println(ans);
    }

    private static int allocation(int L, int R) {
        if (dp[L][R] != -1) {
            return dp[L][R];
        }
        if (a[L] > a[R]) {
            L = (L + 1) % n;
        } else {
            R = (R + n - 1) % n;
        }
        if (L == R) {
            dp[L][R] = a[L];
        } else {
            dp[L][R] = Math.max(a[L] + allocation((L + 1) % n, R), a[R] + allocation(L, (R + n - 1) % n));
        }
        return dp[L][R];
    }

}
