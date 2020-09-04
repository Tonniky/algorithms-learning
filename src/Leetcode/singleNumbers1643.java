package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class singleNumbers1643 {
    public int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }
        int[] res = new int[2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if(set.contains(nums[i])) {
                res[index++] = nums[i];
            }
            if(index == 2) {
                break;
            }
        }
        return res;
    }
    }
