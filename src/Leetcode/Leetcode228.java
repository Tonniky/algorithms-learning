package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            return new ArrayList<>(nums[0]);
        }
        int temp = Integer.MIN_VALUE;
        StringBuilder s;
        boolean Flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                s =new StringBuilder(String.valueOf(nums[i]));
                temp = 0;
            }
            if (temp + 1 == i) {
                temp = nums[i];
            }
        }
        return res;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                    continue;
            }
            if (i == j) {
                res.add(nums[i] + "");
            } else {
                res.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return res;
    }

    }
