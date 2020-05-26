package Leetcode;

public class Leetcode125 {
    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        while(start < end) {
            if(!Character.isLetterOrDigit(ch[start])) {
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(ch[end])) {
                end--;
                continue;
            }
            if ((int) Character.toLowerCase(ch[start]) != (int) Character.toLowerCase(ch[end])){
              return false;
            }
            start++;
            end--;
        }
        return true;
    }
    }
