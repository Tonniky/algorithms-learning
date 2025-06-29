package com.company;

import java.util.*;

public class test {

    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//
//        int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//        String[] str = in.nextLine().split(" ");
//
//        int[] arrs = new int[n];
//        for (int i = 0; i < n; i++) {
//            arrs[i] = Integer.parseInt(str[i]);
//        }


        int n = 10;

        int[] arr = {-1, 0, 4, -3, 6, 5, -6, 5, -7, -3};

        Set<Integer> allMath = new HashSet<>();


        for (int left = 0; left < n; left++) {
            int temp = 0;
            for (int right = left; right < n; right++) {
                temp += arr[right];
                if (!allMath.contains(temp)) {
                    allMath.add(temp);
                }
            }
        }

        int max = 0;
        for (Integer m: allMath) {
            int cur = m;
            int[][] suffix = new int[1000][2];
            int curSum = 0;
            for (int len = 0; len < n; len++) {
                for (int leftIndex = 0; leftIndex < n - len; leftIndex++) {

                    int sum = 0;
                    for (int t = leftIndex; t <= leftIndex + len; t++) {
                        sum += arr[t];
                    }
//                    int sum = getSum(arr, leftIndex, leftIndex + len);
                     if (cur == sum &&  checkValid(suffix, leftIndex, leftIndex + len, curSum)) {
                         suffix[curSum][0] = leftIndex;
                         suffix[curSum][1] = leftIndex + len;
                         curSum++;
                     }

                }
            }
            max = Math.max(max, curSum);
        }
        System.out.println(max);
    }

    public static boolean checkValid(int[][] suffix, int left, int right, int curSum) {
        if (curSum == 0) {
            return true;
        }
        for (int i = 0; i < curSum; i++) {
            int curLeft = suffix[i][0];
            int curRight = suffix[i][1];
            if( (right >= curLeft && right <= curRight) || (right >= curRight && left <= curLeft) || (left >= curLeft && left <= curRight) || (right <= curRight && left >= curLeft)) {
                    return false;
            }
        }
        return true;
    }



    public static int getSum(int[] arr, int leftIndex, int rightIndex) {
        int sum = 0;
        for (int i = leftIndex; i <= rightIndex; i++) {
            sum += arr[i];
        }
        return sum;
    }





}
