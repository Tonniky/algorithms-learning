package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                res.add(Math.abs(index + 1));
            }
            nums[i] = -nums[i];
        }
        return res;
    }
    }
