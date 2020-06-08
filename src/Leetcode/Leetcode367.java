package Leetcode;

public class Leetcode367 {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return false;
        }
        long left = 0, right = num/2, res;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            res = mid * mid;
            if(res == num) {
                return true;
            } else if (res > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
    }
