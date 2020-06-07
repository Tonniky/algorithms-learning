package Leetcode;

public class Leetcode344 {
    public void reverseString(char[] s) {
        help(s, 0, s.length - 1);
    }

    public void help(char[] s, int left, int right) {
        while(left >= right) {
            return;
        }
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        help(s, left, right);
    }
    }
