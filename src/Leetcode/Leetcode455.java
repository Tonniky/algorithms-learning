package Leetcode;

import java.util.Arrays;

public class Leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int leng = g.length;
        int lens = s.length;
        int i = 0;
        int j = 0;
        while (i < leng && j < lens) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
    }
