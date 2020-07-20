package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring3 {
    //
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int len = 0;
        int right = -1;
        Set<Character> set = new HashSet<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        set.contains(ch[0]);
        int slen = ch.length;
        for (int i = 0; i < slen; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right < slen - 1 && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            len = Math.max(len, right + 1 - i);
        }
        return len;
    }
    }
