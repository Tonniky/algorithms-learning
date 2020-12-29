package Leetcode;
import java.util.*;
public class Leetcode10000 {
    public int StringToInt(String str) {
        char[] ch = str.toCharArray();
        int len = ch.length;
        int i = 0;
        int pre = 0;
        boolean flag = true;
        boolean isValid = true;
        int next = 0;
        int res = 0;
        for (i = 0; i < len; i++) {
            if (ch[i] =='-' ) {
                if (i == 0) {
                    flag = false;
                } else {
                    try {
                        flag = false;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if(ch[i] == 'e') {
                isValid = true;
            }  else if (isValid == true) {
                int t = Integer.valueOf(String.valueOf(charChase(ch[i])));
                next = 10 *next + t;
            } else {
                int temp = charChase(ch[i]);
                pre += pre * 10 + temp;
            }
        }
        res = pre * TenHex(next);
        if (flag == false) {
            res = -res;
        }
        return res;
    }
        public int TenHex(int x) {
            x = 1;
            for (int i = 0; i < x; i++) {
                x *= 10;
            }
            return x;
        }

        public char charChase(char s) {
            return (char)(s - 'A' + 'a');
        }
}
