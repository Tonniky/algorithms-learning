package ZCYCodingGuide.listNode;

import java.util.Stack;

public class isPalindrome1 {

    public class ListNode {
        public int val;
        public ListNode (int data) {
            this.val = data;
        }
        public ListNode next;
    }


    public boolean isPalindrome1(ListNode node) {
        if (node == null) {
            return false;
        }
        ListNode cur = node;
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            if (node.val != stack.pop().val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }


    public boolean isPalindrome2(ListNode node) {
        if (node == null) {
            return false;
        }

        ListNode node1 = node.next;
        ListNode node2 = node;
        while(node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        while (node != null) {
            stack.push(node);
        }
        while (!stack.isEmpty()) {
            if (node.val != stack.pop().val) {
                return false;
            }
        }
        return true;
    }


}
