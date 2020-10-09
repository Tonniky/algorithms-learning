package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class changeFormatNumber923 {

    public String changeFormatNumber (String number) {
        char[] ch = number.toCharArray();
        int len = ch.length;
        for (int i = 0; i < len; i++) {
            if (ch[i] == '-' || Character.isDigit(ch[i])) {
               continue;
            } else {
                return "INPUTERROR";
            }
        }
//        if (!number.matches("[0-9]{1,}")) {
//            return "INPUTERROR";
//        }
        int in = Integer.parseInt(number);
        if (in > Math.pow(2,16) - 1 || in < -Math.pow(2,16)) {
            return "NODATA";
        }


        String hexIn = Integer.toHexString(in).toUpperCase();
        String binIn = Integer.toBinaryString(in);
        List<String> temp1 = new ArrayList<>();
        List<String> temp2 = new ArrayList<>();

        if (binIn.length() <= 16 && hexIn.length() <= 4) {
            int c = 16 - binIn.length();
            for (int i = 1; i <= c; i++) {
                temp1.add("0");
            }
            String a1 = temp1.stream().collect(Collectors.joining());
            binIn = a1 + binIn;
        } else if (binIn.length() > 16) {
            binIn = binIn.substring(0, 16);
        }

        if (hexIn.length() <= 4) {
            int n = 4 - hexIn.length();
            for (int i = 0; i <= n;  i++) {
                temp2.add("0");
            }
            String res2 = temp2.stream().collect(Collectors.joining());
            hexIn = res2 + hexIn;
        } else if (hexIn.length() > 4) {
            hexIn = hexIn.substring(0, 4);
        }
       String res = binIn + "," + hexIn;
        return res;
    }

    public static void main(String[] args) {
        changeFormatNumber923 test = new changeFormatNumber923();
        String s = String.valueOf(Math.pow(2,16));
        test.changeFormatNumber("15");
        System.out.printf("5" + 2);
    }

    }
