package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class maxNum {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }

        int[] arr = {8, 8, 9, 1, 9, 6, 3, 9, 1, 0};
        int n = 10;
        int res = getResult(arr, n);
        System.out.println(res);
    }

    private static int getResult(int[] arr, int n) {
        HashMap<Integer, ArrayList<Integer[]>> ranges = new HashMap<>();

        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    int sum = dp[j];
                    ranges.putIfAbsent(sum, new ArrayList<>());
                    ranges.get(sum).add(new Integer[]{0, j});
                } else {
                    int sum = dp[j] - dp[i - 1];
                    ranges.putIfAbsent(sum, new ArrayList<>());
                    ranges.get(sum).add(new Integer[]{i, j});
                }
            }
        }

        int max = 0;
        for (Integer key: ranges.keySet()) {
            ArrayList<Integer[]> range = ranges.get(key);
            max = Math.max(max, disjoint(range));
        }
        return max;
    }

    private static int disjoint(ArrayList<Integer[]> ranges) {
        int count = 1;
        ranges.sort((a, b) -> a[1] - b[1]);

        Integer t = ranges.get(0)[1];
        for (int i = 1; i < ranges.size(); i++) {
            Integer[] range = ranges.get(i);
            Integer l = range[0];
            Integer r = range[1];

            if (t < l) {
                count++;
                t = r;
            }
        }
        return count;
    }


    private int getMaxResult(int[] arr, int n) {
        HashMap<Integer, ArrayList<Integer[]>> ranges = new HashMap<>();

        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    int sum = dp[j];
                    ranges.putIfAbsent(sum, new ArrayList<>());
                    ranges.get(sum).add(new Integer[] {0, j});
                } else {
                    int sum = dp[j] - dp[i];
                    ranges.putIfAbsent(sum, new ArrayList<>());
                    ranges.get(sum).add(new Integer[]{i, j});
                }
            }
        }

        int max = 0;
        for (Integer key: ranges.keySet()) {
            ArrayList<Integer[]> range = ranges.get(key);
            max = Math.max(max, getCount(range));
        }
        return max;
    }

    private static int getCount(ArrayList<Integer[]> ranges) {
        int count = 1;
        ranges.sort((a, b) -> a[1] - b[1]);

        Integer t = ranges.get(0)[1];
        for (int i = 1; i < ranges.size(); i++) {
            Integer[] range = ranges.get(i);
            Integer l = range[0];
            Integer r = range[1];

            if (t < l) {
                count++;
                t = r;
            }
        }
        return count;
    }

}
