package Leetcode;

import java.util.*;

public class nextGreaterElement496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n && nums2[j] != nums1[i]) {
                j++;
            }
            int k = j + 1;
            while (k < n && nums2[k] < nums1[i]) {
                k++;
            }
            res[i] = k < n ? nums2[i] : -1;
        }
        return res;
    }


    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        int n = nums2.length;
        for (int i = n - 1; i >= 0; i--) {
            int in = nums2[i];
            while (!deque.isEmpty() && in >= deque.peek()) {
                deque.pop();
            }
            map.put(in, deque.isEmpty() ? -1 : deque.peek());
            deque.push(in);
        }

        int m = nums1.length;
        int[] res = new int[m];
        for (int j = 0; j < m; j++) {
            res[j] = map.get(nums1[j]);
        }
        return res;
    }


    public static void main(String[] args) {
        nextGreaterElement496 nextGreaterElement496 = new nextGreaterElement496();
        nextGreaterElement496.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});

        nextGreaterElement496.nextGreaterElement2(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }
}
