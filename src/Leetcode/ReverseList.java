package Leetcode;

public class ReverseList {
    public class ListNode {
        public int val;
        public ListNode next;
        public void ListNode(int data) {
            this.val = data;
        }
    }

    public void reverseList(ListNode node) {
        ListNode pre = null;
        ListNode nextNode = null;
        while(node != null) {
            nextNode = node.next;
            node.next = pre;
            pre = node;
            node = nextNode;
        }
    }
}
