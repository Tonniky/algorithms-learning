package Leetcode;

public class Leetcode264 {
    public int nthUglyNumber(int n) {
        int i = 0;
        int j = 0;
        while (true) {
            if (ugly(i)) {
                i++;
                j++;
                if (j == n)
                    break;
            }
        }
        return i;
    }

    public boolean ugly(int n) {
        int[] ug = {2, 3, 5};
        for (int g : ug) {
            while (n % g == 0) {
                n /= g;
            }
        }
        if (n == 1) {
            return true;
        }
        return false;
    }



    }
