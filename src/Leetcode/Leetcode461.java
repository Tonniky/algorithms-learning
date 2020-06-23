package Leetcode;

public class Leetcode461 {
    public int hammingDistance(int x, int y) {
        int max = x >= y ? x : y;
        int min = x >= y ? y : x;
        int num = 0;
        while(max != 0) {
            int p = max % 2;
            max = max / 2;
            int m = min % 2;
            min = min /2;
            if (p != m)
                num++;
        }
        return num;
    }
    }
