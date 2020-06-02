package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode229 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null) {
            return null;
        }
        HashMap<Integer, Integer> record = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int target = nums.length / 3;
        for (int i = 0; i < nums.length; i++) {
            if(record.getOrDefault(nums[i],0) + 1 == target) {
                res.add(nums[i]);
            }
            record.put(nums[i], record.getOrDefault(nums[i],0) + 1);
        }
        return res;
    }
    }
