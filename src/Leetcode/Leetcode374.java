package Leetcode;

public class Leetcode374 {
    public int guessNumber(int n) {
        int left = 1, right = n, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                left = mid + 1;
            } else if (guess(mid) == 1) {
                right = mid - 1;
            }
        }
        return -1;
    }
    public int guess(int n) {
        return -1;
    }
    }
