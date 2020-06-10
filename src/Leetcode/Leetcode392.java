package Leetcode;

public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        char[] ch = s.toCharArray();
        int left = -1;
        for (int i = 0; i < ch.length; i++) {
            left = t.indexOf(ch[i], left + 1);
            if (left == -1) {
                return false;
            }
        }
        return true;
    }
    }
