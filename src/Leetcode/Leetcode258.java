package Leetcode;

public class Leetcode258 {
    public int addDigits(int num) {
     int sum = 0;
     while(num > 9) {
        num = replace(num);
     }
     return num;
    }

    public int replace(int m) {
        char[] temp = String.valueOf(m).toCharArray();
        int n = 0;
        for (int t : temp) {
            n += t - '0';
        }
        return n;
    }

    public static void main(String[] args) {
        Leetcode258 out = new Leetcode258();
        out.addDigits(38);
    }

    }
