package Leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashSet;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int currentSum = 1;
        int maxSum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentSum += 1;
                } else {
                    maxSum = Math.max(currentSum,maxSum);
                    currentSum = 1;
                }
            }
        }
        return Math.max(currentSum,maxSum);
    }


    public int longestConsecutive1(int[] nums) {
        HashSet<Integer> num_set = new HashSet<>();
        for(int num: nums) {
            num_set.add(num);
        }
        int maxSum = 0;
        for(int num : num_set) {
            if(!num_set.contains(num - 1)) {
                int currentSum = 1;
                int current = num;
                while (num_set.contains(current + 1)) {
                    currentSum +=1;
                    current +=1;
                }
                maxSum = Math.max(maxSum,currentSum);
            }
        }
        return maxSum;
    }
    }
