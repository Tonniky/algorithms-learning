package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class maxSlidingWindow1649 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k < 1) {
            return new int[0];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.removeLast();
            queue.addLast(i);
        }
        res[0] = queue.peekFirst();
        for (int j = k; j < len; j++) {
            if(queue.peekFirst() == j - k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[j])
                queue.removeLast();
            queue.addLast(j);
            res[j - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }
    }
