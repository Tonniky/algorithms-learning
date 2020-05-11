package Leetcode;

import java.util.Arrays;

public class Leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 && newInterval.length == 0) {
            return new int[0][0];
        }
        int[][] interval;
        if(intervals.length == 0) {
           interval = new int[1][2];
        } else{
            interval = new int[intervals.length + 1][intervals[0].length];
        }
            if(intervals.length != 0) {
                for (int i = 0; i < intervals.length; i++) {
                    interval[i][0] = intervals[i][0];
                    interval[i][1] = intervals[i][1];
                }
            }
            interval[interval.length - 1][0] = newInterval[0];
            interval[interval.length - 1][1] = newInterval[1];

        Arrays.sort(interval, (a, b) ->a[0] -b[0]);
        int[][] temp = new int[interval.length][interval[0].length];
        int curL = interval[0][0];
        int curR = interval[0][1];
        int j = 0;
        for (int i = 0; i < interval.length; ++i) {
            if(interval[i][1] <= curR) {
            } else if (interval[i][0] <= curR) {
                curR = interval[i][1];
            } else {
                temp[j][0] = curL;
                temp[j][1] = curR;
                curL = interval[i][0];
                curR = interval[i][1];
                j++;
            }
            if(i == interval.length-1) {
                temp[j][0] = curL;
                temp[j][1] = curR;
            }
        }
        int [][] sortResult = new int[j+1][interval[0].length];
        for(int i=0; i <= j; i++) {
            sortResult[i][0] = temp[i][0];
            sortResult[i][1] = temp[i][1];
        }
        return sortResult;
    }

    public static void main(String[] args) {
        int[][] input = {{1,3},{6,9}};
        int[] n = {2,5};
        Leetcode57 res = new Leetcode57();
        int[][] result = res.insert(input,n);
        System.out.println(result);
    }
}
