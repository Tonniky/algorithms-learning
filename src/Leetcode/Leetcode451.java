package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode451 {
    public String frequencySort(String s) {
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            map.put(ch[i],map.getOrDefault(ch[i],0) + 1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> heap = new PriorityQueue<>((e1,e2) -> e2.getValue() - e1.getValue());
        heap.addAll(map.entrySet());
        StringBuilder sortedString = new StringBuilder(s.length());
        while(!heap.isEmpty()) {
            Map.Entry<Character, Integer> en = heap.poll();
            for (int i = 0; i < en.getValue(); i++) {
                sortedString.append(en.getKey());
            }
        }
        return sortedString.toString();
    }
    }
