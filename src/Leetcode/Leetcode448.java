package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= len; i++) {
            if(!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = - nums[index];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ; i < len; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    }
