package Leetcode;

import java.util.HashSet;

public class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return false;
            } else {
                set.add(num);
            }
        }
        return true;
    }
    }
