package Leetcode;


import java.util.HashSet;
import java.util.Set;

public class Leetcode260 {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        for(int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int j = 0;
        for (Integer s : set) {
            res[j++] = s;
        }
        return res;
    }
    }
