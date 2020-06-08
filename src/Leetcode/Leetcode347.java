package Leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return new int[]{nums[0]};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0 ) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] topK = new int[k];
        for(int i = 0; i < k; i++) {
            topK[i] = heap.poll();
        }
        return topK;
    }

    public static void main(String[] args) {
        Leetcode347 out = new Leetcode347();
        int[] nums = {1,1,1,2,2,3};
        int top = 2;
        out.topKFrequent(nums, top);
    }
    }
