package Leetcode;

public class Leetcode415 {
    public String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int len1 = num1.length() - 1, len2 = num2.length(), carry = 0;
        while (len1 >= 0 || len2 >= 0) {
            int n1 = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int n2 = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            s.append(temp / 10);
            len1--;
            len2--;
        }
        if (carry == 1) s.append("1");
        return s.reverse().toString();
    }
    }
