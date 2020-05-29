package Leetcode;

public class Leetcode191 {
    public int hammingWeight(int n) {
        int num = 0;
        int pos = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & pos) != 0) {
                num++;
            }
            pos <<= 1;
        }
        return num;
    }
    }
