package Leetcode;

public class divideString5980 {
    public  static String[] divideString(String s, int k, char fill) {
        char[] ch = s.toCharArray();
        int x = ch.length % k == 0 ? 0 : 1;
        int len = x + ch.length / k;
        String[] res = new String[len];
        int j = 0;
        String temp = "";
        for (int i = 0; i < len * k; i++) {
            if (i >= ch.length) {
                temp += fill;
            } else {
                temp += ch[i];
            }
            if (temp.length() == k) {
                res[j++] = temp;
                temp = "";
            }
        }
        return res;
    }

    public static void main(String[] args) {
       String[] st = divideString("abcdefghi", 3, '*');
        System.out.println(st);
    }
}
