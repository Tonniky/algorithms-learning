package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class numSub5461 {
    public int numSub(String s) {
        char[] ch = s.toCharArray();
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = ch.length;
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            if (i == ch.length - 1 && String.valueOf(ch[i]).equals("1")) {
                count++;
                m.put(count, m.getOrDefault(count,0) + 1);
            }
            if (String.valueOf(ch[i]).equals("1")) {
                count++;
            }
            if (String.valueOf(ch[i]).equals("0")) {
                m.put(count, m.getOrDefault(count, 0) + 1);
                count = 0;
            }
        }
        long sum = 0;
        for (Integer temp : m.keySet()) {
            long k = m.get(temp);
            long kTemp = k * temp * (temp + 1) / 2;
            sum += kTemp;
        }
        sum = sum % ((long)(Math.pow(10, 9) + 7));
        return (int)sum;
    }
}
