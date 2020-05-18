package Leetcode;

import java.util.List;

public class Leetcode92 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int data) {
            this.val = data;
        }
    }

    private boolean stop;
    private ListNode left;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.reversePoint(head, m, n);
        return head;
    }

    public void reversePoint(ListNode right, int m, int n) {
        if(m == 1)
            return;

        right = right.next;
        if (m > 1) {
            this.left = this.left.next;
        }
        this.reversePoint(right,m + 1, n - 1);

        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        if(!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;
            this.left = left.next;
        }

    }

    }
