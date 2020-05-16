package Leetcode;

public class Leetcode86 {
    public class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int data) {
            this.val = data;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode highHead = new ListNode(0);
        ListNode after = highHead;
        ListNode lowHead = new ListNode(0);
        ListNode before = lowHead;
        while(head != null) {
            if(head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = highHead.next;
        return lowHead.next;
    }
    }
