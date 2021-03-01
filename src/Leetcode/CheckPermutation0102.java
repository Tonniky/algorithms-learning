package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        if (chs1.length != chs2.length) {
            return false;
        }
        int len = chs1.length;
        Map<Character, Integer> record = new HashMap<Character, Integer>();
        for (int i = 0; i < len; i++) {
            record.put(chs1[i],record.getOrDefault(chs1[i],0) + 1);
        }
        for (int j = 0; j < len; j++) {
            if (!record.containsKey(chs2[j]) || record.get(chs2[j]) <= 0) {
                return false;
            }
            record.put(chs2[j], record.get(chs2[j]) - 1);
        }
        return true;
    }
    }
