//package Leetcode;
//
//
//import sun.jvm.hotspot.utilities.Interval;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class eraseOverlapIntervals435 {
//
//    class myComparator implements Comparator<Interval> {
//        @Override
//        public int compare(Interval a, Interval b) {
//            return a.start - b.start;
//        }
//    }
//    public boolean isOverlapping(Interval i, Interval j) {
//        return i.end > j.start;
//    }
//    public int eraseOverlapIntervals(Interval[] intervals) {
//        if (intervals.length == 0) {
//            return 0;
//        }
//        Arrays.sort(intervals, new myComparator());
//        int dp[] = new int[intervals.length];
//        dp[0] = 1;
//        int ans = 1;
//        for (int i = 1; i < dp.length; i++) {
//            int max = 0;
//            for (int j = i - 1; j >= 0; j--) {
//                if (!isOverlapping(intervals[j], intervals[i])) {
//                    max = Math.max(dp[j], max);
//                }
//            }
//            dp[i] = max + 1;
//            ans = Math.max(ans, dp[i]);
//
//        }
//        return intervals.length - ans;
//    }
//
//    }
