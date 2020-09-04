package Leetcode;

public class reverseListNode {
    public class Node {
        public int val;
        public Node next;
        public Node(int data) {
            this.val = data;
        }
    }


    public static Node reverseListNode(Node head){
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
