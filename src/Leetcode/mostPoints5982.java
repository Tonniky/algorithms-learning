package Leetcode;

public class mostPoints5982 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] num = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int[] q = questions[i];
            int j = i + q[1] + 1;
            num[i] = Math.max(num[i + 1], q[0] + (j < n ? num[j] : 0));
        }
        return num[0];
    }

    public long mostPoints1(int[][] questions) {
        int n = questions.length;
        int[] num = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int[] q = questions[i];
            int next = Math.min(n, q[0] + 1 + i);
            num[next] = Math.max(q[0] + num[i], num[next]);
        }
        return num[n];
    }
    }
