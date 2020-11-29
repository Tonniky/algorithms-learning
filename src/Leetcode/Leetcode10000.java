package Leetcode;
import java.util.*;
public class Leetcode10000 {
    public int StringToInt(String str) throws Execption() {
        Char[] ch = str.toCharArray();
        int len = ch.length;
        int i = 0;
        int pre = 0;
        boolean flag = true;
        boolean isValid = 0;
        int next = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (ch[i] =='-' ) {
                if (i == 0) {
                    flag = false;
                } else
              try(){
                    {
                    flag = false;
                }
                } catch(e Execption) {
                    Sysmtem.out.print("invalid input!!");
                }
            } else if(ch[i] == 'e') {
                isValid = true;
            }  else if (isValid == true) {
                int t = charChase(ch[i]);
                next = 10 *next + t;
            } else {
                int temp = charChase(ch[i]);
                pre += pre * 10 + temp;
            }
        }
        res = pre * TenHex(x);
        if (flag == false) {
            res = -res;
        }
        return res;
    }
        public int TenHex(int x) {
            int x = 1;
            for (int i = 0; i < x; i++) {
                x *= 10;
            }
            return x;
        }

        public int charChase(char[] s) {
            return s - '45' + 0;
        }
}
