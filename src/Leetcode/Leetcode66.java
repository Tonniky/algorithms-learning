package Leetcode;

public class Leetcode66 {

    //这个反例，不要投机取巧，引以为戒！
    public int[] plusOne(int[] digits) {
        long num = 0;
        if (digits.length == 0) {
            return null;
        }
        for (int i =0; i < digits.length; i++) {
            int temp = digits[i];
            num = num * 10 + temp;
        }
        long newNum = num + 1;
        String str = String.valueOf(newNum);
        int[] res = new int[str.length()];
        for (int i = res.length-1; i >= 0; i--) {
           res[i] =(int)(newNum%10);
           newNum = newNum/10;
        }
        return res;
    }

    public int[] plusOne1(int[] digits) {
        for(int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0) return digits;
        }
        digits = new int[digits.length +1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] input = {9,9};
        Leetcode66 out = new Leetcode66();
        out.plusOne1(input);
    }
}
