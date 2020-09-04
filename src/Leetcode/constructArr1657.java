package Leetcode;

public class constructArr1657 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        if (a.length == 0) {
            return new int[0];
        }
        if (a.length == 1) {
            return new int[1];
        }
        int len = a.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = 1;
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    temp *= a[j];
                }
            }
            res[i] = temp;
        }
        return res;
    }
    }
