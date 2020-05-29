package Leetcode;

public class Leetcode206 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode (int data) {
            this.val = data;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    }
