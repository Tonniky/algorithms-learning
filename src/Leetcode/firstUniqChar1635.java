package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class firstUniqChar1635 {
    public char firstUniqChar(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(ch[i],map.getOrDefault(ch[i],0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if(map.get(ch[i]) == 1) {
                return ch[i];
            }
        }
        return ' ';
    }


    public char firstUniquChar1(String s) {
        char[] ch = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        int len = ch.length;
        for (int i = 0; i < len; i++) {
            if(deque.contains(ch[i])) {
                deque.remove(ch[i]);
            } else {
                deque.addLast(ch[i]);
            }
        }
        if (deque.isEmpty()) {
            return ' ';
        }
        return deque.peekFirst();
    }
    }
