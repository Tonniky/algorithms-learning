package Leetcode;

public class Leetcode476 {
    public int findComplement(int num) {
        int pos = 0;
        while(num!= 0) {
            num = num / 2;
            pos++;
        }
        int res = (int)Math.pow(2, pos) - 1 - num;
        return res;
    }

    public static void main(String[] args) {
        Leetcode476 out = new Leetcode476();
        out.findComplement(5);
    }

    }
