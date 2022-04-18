package Leetcode;

import java.util.PriorityQueue;

public class maximumProduct6039 {

    /**
     * 通过率 14/72
     *
     * */
    public static int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int m: nums) {
            pq.offer(m);
        }
        for (int i = 0; i < k; i++) {
            int temp = pq.poll();
            temp++;
            pq.offer(temp);
        }
        long res = 1;
        int mod = (int) 1e9 + 7;
        while (!pq.isEmpty()) {
            res = pq.poll() * res % mod;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int[] test = {24,5,64,53,26,38};
        int k = 54;
        maximumProduct(test, k);
    }
}
