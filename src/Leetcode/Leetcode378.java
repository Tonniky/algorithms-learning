package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int num : row) {
                if (queue.size() == k && num > queue.peek())
                    break;
                queue.add(num);
                if (queue.size() > k) {
                    queue.remove();
                }
            }
        }
        return queue.remove();
    }
    }
