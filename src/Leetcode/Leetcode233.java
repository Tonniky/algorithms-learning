package Leetcode;

public class Leetcode233 {
    public int countDigitOne(int n) {
        if(n < 1) {
            return 0;
        }
        int num = 0;
        for (int i = 1; i <= n; i++) {
            do {
                int temp = i % 10;
                if ( temp == 1)
                    num++;
            } while (i / 10 != 0);
        }
        return num;
    }
    }
