package Leetcode;

import java.util.*;

public class Leetcode315 {
//    public List<Integer> countSmaller(int[] nums) {
//        if (nums == null)
//            return null;
//        Stack<Integer> stack = new Stack<>();
//        int len = nums.length;
//        List<Integer> res = new ArrayList<>();
//    for (int i = len - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && stack.peek() > nums[i]) {
//                stack.pop();
//            }
//            stack.add(nums[i]);
//            nums[i] = stack.size() - 1;
//        }
//    for (int i = 0; i < len; i++) {
//        res.add(nums[i]);
//    }
//        return res;
//    }

        public List<Integer> countSmaller(int[] nums) {
            if (nums == null)
                return null;
            int len = nums.length;
            List<Integer> res = new ArrayList<>();
            if (len == 0)
                return res;
            if (len == 1) {
                res.add(0);
                return res;
            }
            for (int i = 0; i < len - 1; i++) {
                int sum = 0;
                for (int j = i + 1; j < len; j++) {
                    if (nums[i] > nums[j])
                        sum++;
                }
                res.add(sum);
            }
            res.add(0);
            return res;
        }



}
