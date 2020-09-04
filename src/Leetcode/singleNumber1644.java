package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class singleNumber1644 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 0) {
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        int res = 0;
        for (int i =0 ; i < len; i++) {
            if (map.get(nums[i]) == 1)
                res = nums[i];
        }
        return res;
    }
    }
