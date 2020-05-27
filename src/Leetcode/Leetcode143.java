package Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Leetcode143 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode (int data) {
            this.val = data;
        }
    }
    public void reorderList(ListNode head) {
        Queue<ListNode> stack = new ArrayDeque<>();
        ListNode list1 = head;
        while(head !=null) {
            stack.add(head);
            head = head.next;
        }
        ListNode res = head;
        while(stack != null) {
            res.next = stack.poll();
            res.next = stack.remove();
        }
    }



    }
