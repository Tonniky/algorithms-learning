package Leetcode;

public class Leetcode342 {
    public boolean isPowerOfFour(int num) {
        if (num == 1)
            return true;
        if(num < 4) {
          return false;
        }
        while (num % 4 ==0) {
          num /= 4;
        }
        return num == 1;
    }
    }
