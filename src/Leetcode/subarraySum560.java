package Leetcode;
import java.util.*;
public class subarraySum560 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int len = nums.length;
        if (len == 1) {
            return nums[0] == k ? 1 : 0;
        }
        for (int end = 0; end < len; end++) {
            int num = 0;
            for (int start = end; start >= 0; start--) {
                num += nums[start];
                if (num == k)
                    sum++;
            }
        }
        return sum;
    }


    public int subarraySum2(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        int len = nums.length;
        int pre = 0;
        for(int i = 0; i < len; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)) {
              sum += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return sum;
    }


    }
