package Leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                stack.push(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode350 out = new Leetcode350();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        out.intersect(nums1, nums2);
    }
    }
