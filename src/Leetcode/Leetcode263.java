package Leetcode;

public class Leetcode263 {
    public boolean isUgly(int num) {
        if(num < 1) {
            return false;
        }
        int[] tem = {2, 3, 5};
        for (int t: tem) {
            while (num % t == 0) {
                num = num / t;
            }
        }
        if (num == 1) {
            return true;
        }
        return false;
    }
    }
