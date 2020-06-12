package Leetcode;

public class Leetcode434 {
    public int countSegments(String s) {
        s = s.trim();
        if (s.equals("")){
            return 0;
        }
        return s.split("\\s+").length;
    }

    public int countSegments1(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
    }
