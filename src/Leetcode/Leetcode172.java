package Leetcode;

public class Leetcode172 {
    public int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }
        long num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        int len = 0;
        while(num != 0) {
            if (num % 10 == 0) {
                len++;
                num /= 10;
            } else
                break;
        }
        return len;
    }

    public int trailingZeroes1(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }

    public static void main(String[] args) {
        int n = 13;
        Leetcode172 out = new Leetcode172();
        out.trailingZeroes1(n);
    }
    }
