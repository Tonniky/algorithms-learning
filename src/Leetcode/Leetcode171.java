package Leetcode;

public class Leetcode171 {
    public int titleToNumber(String s) {
        char[] ch = s.toCharArray();
        int num = 0;
        for (int i = 0; i < ch.length; i++) {
            int temp = (int)(ch[i] - 'A' + 1);
            num = num * 26 + temp;
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "AB";
        Leetcode171 out = new Leetcode171();
        out.titleToNumber(s);
    }
    }
