package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) +1);
        }
        int n = nums.length / 2;
        for(Integer entry: map.keySet()) {
            if(map.get(entry) > n) {
                return entry;
            }
        }
        return 0;
    }
}
