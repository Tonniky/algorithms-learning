package Leetcode;

public class Leetcode397 {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        if (n <= 3)
            return n - 1;
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            return Math.min(integerReplacement(n - 1) + 1, integerReplacement(n + 1) + 1);
        }
    }

    public int integerReplacement1(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n = n >> 1;
                count++;
            } else {
                if ((n & 2) == 0) {
                    n -= 1;
                    count++;
                } else {
                    if (n == 3) {
                        count += 2;
                        return count;
                    } else {
                        n += 1;
                        count++;
                    }
                }
            }

        }
        return count;
    }
}



