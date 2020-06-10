package Leetcode;

import java.util.HashMap;

public class Leetcode395 {
    public int longestSubstring(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] chs = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char i = 0; i < chs.length; i++) {
            map.put(chs[i], map.getOrDefault(chs[i], 0) + 1);
        }
        int res = 0;
        for(Character key : map.keySet()) {
            if(map.get(key) >= k) {
                res += map.get(key);
            }
        }
        return res;
    }
    }
