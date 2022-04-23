package Leetcode;

public class digitSum6070 {
    public String digitSum(String s, int k) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        if (len <= 3) {
            return s;
        }
        while (s.length() > k) {
          s = convertString(s, k);
        }
        return s;
    }

    public String convertString(String s, int k) {
        char[] chr = s.toCharArray();
        int len = s.length();
        String temp = "";
        int t = 0;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (index == k - 1 || i == len - 1) {
                t += chr[i] - '0';
                index = 0;
                temp = temp + String.valueOf(t);
                t = 0;
            } else {
                t += chr[i] - '0';
                index++;
            }
        }
        return temp;
    }


    public static void main(String[] args) {
        digitSum6070 digitSum6070 = new digitSum6070();
        digitSum6070.digitSum("01234567890", 2);
    }


    }
