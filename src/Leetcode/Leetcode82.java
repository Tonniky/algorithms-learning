package Leetcode;

public class Leetcode82 {
    public class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int data) {
            this.val = data;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        while(cur.next != null && cur.next.next != null ) {
            if(cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while(temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
        public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val ) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            }
            else
                cur = cur.next;
        }
        return dummy.next;
    }

    }
