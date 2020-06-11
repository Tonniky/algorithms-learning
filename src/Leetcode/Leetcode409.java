package Leetcode;

import java.util.HashMap;

public class Leetcode409 {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int len = ch.length;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
        }
        int sin = 0;
        for (char m : map.keySet()) {
            if (map.get(m) % 2 != 0) {
                sin++;
            }
        }
        return sin == 0 ? len : len - sin + 1;
    }
}
