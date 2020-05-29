package Leetcode;

import java.util.Arrays;

public class Leetcode204 {
    public int countPrimes(int n) {
        if (n < 3){
            return 0;
        }
//        if (n == 3) {
//            return 1;
//        }
//        if (n == 4) {
//            return 2;
//        }
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for ( int i = 2 ; i < n ; i++) {
            if (prime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i])
                num++;
        }
        return num;
    }
    }
