package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode205 {
    public boolean isIsomorphic(String s, String t) {
        return isValid(s, t) && isValid(t, s);
    }

    public boolean isValid(String s, String t) {
        if(s == null) {
            return false;
        }
        int len = s.length();
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Character s1 = s.charAt(i);
            Character t1 = t.charAt(i);
            if (map.containsKey(s1)) {
                if (!map.get(s1).equals(t1)) {
                    return false;
                }
            } else {
                map.put(s1, t1);
            }
        }
        return true;
    }
    }
