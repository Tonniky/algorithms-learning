package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class majorityElement1624 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int gap = len / 2;
        String s = Integer.toString(gap);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(map.containsKey(nums[i]) && map.get(nums[i]) == gap) {
                return nums[i];
            } else {
                map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            }
        }
        return 0;
    }
}
