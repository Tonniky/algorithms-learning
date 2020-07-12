package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class numIdenticalPairs5460 {
    public int numIdenticalPairs(int[] nums) {
        int num = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        for (Integer m : map.keySet()) {
            int n = map.get(m);
            int temp = n * (n - 1) / 2;
            num += temp;
        }
        return num;
    }
}
