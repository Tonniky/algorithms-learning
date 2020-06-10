package Leetcode;

public class Leetcode396 {
    public int maxRotateFunction(int[] A) {
        if(A == null || A.length < 2) {
            return 0;
        }
        int len = A.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int temp = 0;
            for (int j = 0; j < len; i++) {
                temp += (i + j > (len - 1) ? (i + j) - len : (i + j)) * A[j];
            }
            sum = Math.max(temp,sum);
        }
        return sum;
    }
    public int maxRotateFunction1(int[] A) {
        int sum = 0;
        int dp1 = 0, dp2 = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            dp1 += i * A[i];
        }

        int ans = dp1;
        for (int i = 1; i < A.length; i++) {
            dp2 = dp1 + sum - A.length * A[A.length - i];
            ans = Math.max(dp2, ans);
            dp1 = dp2;
        }

        return ans;
    }


    }
