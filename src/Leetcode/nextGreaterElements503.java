package Leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class nextGreaterElements503 {
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        int n = nums2.length;
        int m = nums1.length;
        int[] res = new int[m];
        for (int i = n - 1; i >= 0; i--) {
            int in = nums2[i];
            while (!deque.isEmpty() && in >= deque.peek()) {
                deque.pop();
            }
            map.put(in, deque.isEmpty() ? -1 : deque.peek());
            deque.push(in);
            if (i < nums1.length) {
                res[i] = map.get(nums1[i]);
            }
        }
        return res;
    }

    public int[] nextGreaterElements(int[] nums) {
        int m = nums.length;
        int[] nums2 = new int[2 * m];
        for (int i = 0; i < 2 * m ; i++) {
            if (i < m) {
                nums2[i] = nums[i];
            } else {
                nums2[i] = nums[i - m];
            }
        }
       return nextGreaterElement2(nums, nums2);
    }

    public static void main(String[] args) {
        nextGreaterElements503 nextGreaterElements503 = new nextGreaterElements503();
        nextGreaterElements503.nextGreaterElements(new int[]{100,1,11,1,120,111,123,1,-1,-100});
    }
    }
