package Leetcode;
import java.util.*;
public class checkSubarraySum523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = 0;
                for (int m = i; m <= j; m++) {
                    temp += nums[m];
                }
                if ((temp == k) || (k != 0 && temp % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //这个方法很精妙，使用的是两个数字想减，然后得到了中间必然有整除的。
    public boolean checkSubarraySum2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int len = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 2) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    }
