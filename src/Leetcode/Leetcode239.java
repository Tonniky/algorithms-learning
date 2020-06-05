package Leetcode;

import java.util.LinkedList;

public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k < 1 || nums.length < k) {
            return null;
        }
        int len = nums.length;
        int[] res = new int[len - k + 1];
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while(!qmax.isEmpty() && nums[qmax.peekLast()] < nums[i]) {
                qmax.peekLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i - k) {
                qmax.removeFirst();
            }
            if(i >= k - 1) {
                res[i] = qmax.peekFirst();
            }
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        if(len * k == 0) {
            return new int[0];
        }
        int[] out = new int[len - k + 1];
        for (int i = 0 ; i < len - k + 1; i++ ) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max,nums[j]);
            }
            out[i] = max;
        }
        return out;
    }



    }
