package Leetcode;

import java.util.HashMap;

public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        for (char ch : chs) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : cht) {
            if (!map.containsKey(ch)) {
               return false;
            } else {
               if (map.get(ch) == 1) {
                   map.remove(ch);
               }  else {
                   map.put(ch, map.get(ch) - 1);
               }
            }
        }
        if (map.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Leetcode242 out = new Leetcode242();
        out.isAnagram("a", "b");
    }
    }
