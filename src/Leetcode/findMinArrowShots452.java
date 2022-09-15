package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShots452 {

    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int pos = points[0][1];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pos) {
                res++;
                pos = points[i][1];
            }
        }
        return res;
    }

        //
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {  //
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        findMinArrowShots452 test = new findMinArrowShots452();
        test.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}});
    }
    }
