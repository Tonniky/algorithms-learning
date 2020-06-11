package Leetcode;

public class Leetcode405 {
    public String toHex(int num) {
        char[] hex = "0123456789abcdef".toCharArray();
        String s = new String();
        while(num != 0){
            int end = num&15;
            s = hex[end] + s;
            //无符号右移
            num >>>=4;
        }
        if(s.length() == 0){
            s = "0";
        }
        return s;
    }

    public static void main(String[] args) {
        Leetcode405 out = new Leetcode405();
        out.toHex(-1);
    }

    }
