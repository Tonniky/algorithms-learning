package Leetcode;

public class Leetcode83 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int data) {
            this.val = data;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode cur = head;
        while(cur.next != null) {
            if(cur.val == cur.next.val) {
                ListNode temp = cur.next;
                while(temp.next != null && temp.val == cur.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            }
               cur = cur.next;

        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if(current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    }
