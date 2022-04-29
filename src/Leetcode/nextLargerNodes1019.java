package Leetcode;

import java.util.*;

public class nextLargerNodes1019 {

    //
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // nextLargerNodes
    public int[] nextLargerNodes(ListNode head) {
        // step1
        // 链表转数组
        List<Integer> ls = new LinkedList<>();
        // 辅助哈希表，记录各元素的索引位置，相同元素可能出现多次。方便回溯查找。
        HashMap<Integer, LinkedList<Integer>> valIndexMap = new HashMap<>();
        int index = 0;
        while (head != null) { // index
            int val = head.val;
            ls.add(val);
            // 记录各元素索引位置 valIndexMap
            if (valIndexMap.get(val) == null) {
                valIndexMap.put(val, new LinkedList<>());
            }
            // 重复元素，按顺序记录索引位置
            valIndexMap.get(val).add(index);
            index++;
            head = head.next;
        }
        int[] rs = ls.stream().mapToInt(Integer::intValue).toArray();

        // step2
        // 单调递减栈
        LinkedList<Integer> drabQueue = new LinkedList<>();
        // 遍历数组
        for (int i = 0; i < rs.length; i++) {
            int val = rs[i];
            // 在单调递减栈中，遇到下一个更大元素
            while (!drabQueue.isEmpty() && val > drabQueue.peek()) {
                // 弹出栈顶，从辅助哈希表中找到元素索引列表
                Queue<Integer> queue = valIndexMap.get(drabQueue.poll());
                while (!queue.isEmpty() && i >= queue.peek()) {
                    // 更新当前索引之前的元素
                    rs[queue.poll()] = val;
                }
            }
            // 单调递减栈入队
            drabQueue.addFirst(val);
        }

        // step3
        // 最后栈尾元素处理，剩余元素都是匹配不到下一个最大值
        while (!drabQueue.isEmpty()) {
            int key = drabQueue.poll();
            Queue<Integer> queue = valIndexMap.get(key);
            while (!queue.isEmpty()) {
                // 依题意全部置0
                rs[queue.poll()] = 0;
            }
        }

        return rs;
    }

    public int[] nextLargerNodes1(ListNode head) {
        List<Integer> ls = new LinkedList<>();
        Map<Integer, LinkedList<Integer>> indexMap = new HashMap<>();
        int index = 0;
        while(head != null) {
            int val = head.val;
            ls.add(val);
            if (indexMap.get(val) == null) {
                indexMap.put(val, new LinkedList<>());
            }
            indexMap.get(val).add(index);
            head = head.next;
            index++;
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] gs = ls.stream().mapToInt(Integer::intValue).toArray();
        int len = gs.length;
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && gs[i] > deque.peek()) {
                Queue<Integer> karpQueue = indexMap.get(deque.getFirst());
                while(!karpQueue.isEmpty() && karpQueue.peek() < i) {
                    gs[karpQueue.poll()] = gs[i];
                }
            }
            deque.addFirst(gs[i]);
        }

        while(!deque.isEmpty()) {
            int temp = deque.poll();
            Queue<Integer> queue = indexMap.get(temp);
            if (!queue.isEmpty()) {
                gs[queue.poll()] = 0;
            }
        }
        return gs;
    }

//    public static void main(String[] args) {
//        nextLargerNodes1019 nextLargerNodes1019 = new nextLargerNodes1019();
//        nextLargerNodes1019.nextLargerNodes1();
//    }


    }
