package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Leetcode403 {
    public boolean canCross(int[] stones) {
        HashSet<Integer> set = new HashSet<>();
        for(int s : stones) {
            set.add(s);
        }
        int last = stones[stones.length - 1];
        int start = 0;
        int step = 1;
        return run(start, step, set, last);
    }

    public boolean run(int start, int step, HashSet<Integer> set, int last) {
        if(last == start) {
            return true;
        }
        if (step <=0 ) {
            return false;
        }
        if(!set.contains(start + step)) {
            return false;
        }
        return run(start + step + 1, step + 1, set, last) || run(start + step, step, set,
                last) || run(start + step - 1, step - 1, set, last);
    }

    public boolean canCross1(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for(int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if(step > 0 && map.containsKey(step + stones[i])) {
                        map.get(step + stones[i]).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }


    }
