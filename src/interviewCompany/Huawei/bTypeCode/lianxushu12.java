package interviewCompany.Huawei.bTypeCode;

import java.util.HashMap;
import java.util.Scanner;

public class lianxushu12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        String s = in.next();
//        int k = in.nextInt();

        String s = "432111111111";
        int k = 4;

        HashMap<Character, Integer> base = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            base.put(c, base.getOrDefault(c, 0) + 1);
        }

        int i = 1;
        while (i <= 1000 - k + 1) {
            HashMap<Character, Integer> count = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                String num = String.valueOf(j);
                for (int m = 0; m < num.length(); m++) {
                    char c = num.charAt(m);
                    count.put(c, count.getOrDefault(c, 0) + 1);
                }
            }

            boolean isMatch = true;
            for (Character c: base.keySet()) {
                if (!count.containsKey(c) || count.get(c) - base.get(c) != 0) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                System.out.println(i);
                return;
            }
            i++;
        }
    }

}
