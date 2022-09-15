package Leetcode;


import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlapIntervals435 {

    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int res = 0;
        int left = intervals[0][0];
        for (int i = 1; i < n; i++) {
            if (left <= intervals[i][0]) {
                res++;
                left = intervals[i][1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        eraseOverlapIntervals435 eraseOverlapIntervals435 = new eraseOverlapIntervals435();
        eraseOverlapIntervals435.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
    }

}
