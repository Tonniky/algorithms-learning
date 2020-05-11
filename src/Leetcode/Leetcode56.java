package Leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return null;
        }
        Arrays.sort(intervals, (a,b) ->a[0] -b[0]);
        int[][] temp = new int[intervals.length][intervals[0].length];
        int curL = intervals[0][0];
        int curR = intervals[0][1];
        int j = 0;
        for (int i = 0; i < intervals.length; ++i) {
           if(intervals[i][1] <= curR) {
           } else if (intervals[i][0] <= curR) {
                curR = intervals[i][1];
            } else {
                temp[j][0] = curL;
                temp[j][1] = curR;
                curL = intervals[i][0];
                curR = intervals[i][1];
                j++;
            }
            if(i == intervals.length-1) {
                temp[j][0] = curL;
                temp[j][1] = curR;
            }
        }
        int [][] sortResult = new int[j+1][intervals[0].length];
        for(int i=0; i <= j; i++) {
            sortResult[i][0] = temp[i][0];
            sortResult[i][1] = temp[i][1];
        }
        return sortResult;
    }

    public static void main(String[] args) {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        Leetcode56 res = new Leetcode56();
        int[][] result = res.merge(input);
        System.out.println(result);
    }

}
