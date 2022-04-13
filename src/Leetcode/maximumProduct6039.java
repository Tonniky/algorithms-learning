package Leetcode;

import java.util.PriorityQueue;

public class maximumProduct6039 {

    // 
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            pq.offer(nums[i]);
        }
        while (k-- >= 0) {
          int t = pq.poll();
          t++;
          pq.offer(t);
        }
        int mod = 1000000007;
        long res = 1;
        while(!pq.isEmpty()) {
            res = res * pq.poll() % mod;
        }
        return (int)res;
    }
    }
