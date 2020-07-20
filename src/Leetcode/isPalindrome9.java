package Leetcode;

public class isPalindrome9 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] ch = s.toCharArray();
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (ch[l] == ch[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        if (l == r || l + 1 == r)
            return true;
        return false;
    }
    }
