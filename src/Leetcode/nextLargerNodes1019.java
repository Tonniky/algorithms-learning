package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class nextLargerNodes1019 {
    public int[] nextLargerNodes(Leetcode206.ListNode head) {
        List<Integer> ls = new LinkedList<>();

        HashMap<Integer, LinkedList<Integer>> valIndexMap = new HashMap<>();
        int index = 0;
        while ( head != null) {
            int val = head.val;
            ls.add(val);

            if (valIndexMap.get(val) == null) {
                valIndexMap.put(val, new LinkedList<>());
            }
            valIndexMap.get(val).add(index);
            index++;
            head = head.next;
        }

        int[] rs = ls.stream().mapToInt(Integer::intValue).toArray();

        LinkedList<Integer> drabQueue = new LinkedList<>();

        for (int i = 0; i < rs.length; i++) {
            int val = rs[i];

            while (!drabQueue.isEmpty() && val > drabQueue.peek()) {
                Queue<Integer> queue = valIndexMap.get(drabQueue.poll());
                while (!queue.isEmpty() && i >= queue.peek()) {
                    rs[queue.poll()] = val;
                }
             }
            drabQueue.addFirst(val);
        }

        while (!drabQueue.isEmpty()) {
            int key = drabQueue.poll();
            Queue<Integer> queue = valIndexMap.get(key);
            while (!queue.isEmpty()) {
                rs[queue.poll()] = 0;
            }
        }
        return rs;
    }

    public static void main(String[] args) {

    }
}
