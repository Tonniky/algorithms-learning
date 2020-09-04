package Leetcode;

public class strToInt1658 {

    public int strToInt(String str) {
        char[] ch = str.toCharArray();
        int res = 0;
        for (char i : ch) {
            res = res * 10 + (i - '0');
        }
        return res;
    }
    }
