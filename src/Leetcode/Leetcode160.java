package Leetcode;

public class Leetcode160 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode (int data) {
            this.val = data;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode listA = headA, listB = headB;
        int lenA = 0, lenB = 0;
        while (listA != null) {
            listA = listA.next;
            lenA++;
        }
        while (listB != null) {
            listB = listB.next;
            lenB++;
        }
        int required = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while(required > 0) {
                headA = headA.next;
                required--;
            }
        }
        if (lenA < lenB) {
            while(required > 0) {
                headB = headB.next;
                required--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA , nodeB = headB;
        while(nodeA != nodeB) {
            nodeA = nodeA != null ? nodeA.next : headB;
            nodeB = nodeB != null ? nodeB.next : headA;
        }
        return nodeA;
    }

    }
