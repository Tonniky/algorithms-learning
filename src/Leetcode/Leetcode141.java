package Leetcode;

import java.util.HashSet;

public class Leetcode141 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode (int data) {
            this.val = data;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!= null && fast.next.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast != null && fast.val == slow.val) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        while(head!=null) {
            if(set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
    }
