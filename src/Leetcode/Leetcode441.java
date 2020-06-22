package Leetcode;

public class Leetcode441 {
    public int arrangeCoins(int n) {
        if(n <= 0) {
            return 0;
        }
        int num = 0;
        int row = 1;
        while (n >= row) {
            n -= row++;
            num++;
        }
        return num;
    }
    }
