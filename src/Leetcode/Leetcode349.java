package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num) && !stack.contains(num)) {
             stack.add(num);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
    }
