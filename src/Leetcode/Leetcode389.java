package Leetcode;

import java.util.HashMap;

public class Leetcode389 {
    public char findTheDifference(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            map.put(chs[i], map.getOrDefault(chs[i], 0) + 1);
        }
        for (int i = 0; i < cht.length; i++) {
            if (!map.containsKey(cht[i]) || map.get(cht[i]) == 0) {
                return cht[i];
            } else {
                map.put(cht[i], map.get(cht[i]) - 1);
            }
        }
        return cht[cht.length];
    }
    }
