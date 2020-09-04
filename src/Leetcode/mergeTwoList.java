package Leetcode;

public class mergeTwoList {

    public class Node {
        public int val;
        public Node next;
        public Node (int data) {
            this.val = data;
        }
    }


    public static Node mergeTwoList(Node head1, Node head2) {
        if (head1 == null && head2 ==null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node head = null;
        if (head1.val > head2.val) {
            head = head2;
            mergeTwoList(head1, head);
        } else {
            head = head1;
            mergeTwoList(head,head2);
        }
        return head;
    }



    public Node mergeTwoList3(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        //
        Node head = head1.val < head2.val ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head2 ? head2 : head1;
        Node pre = null;
        Node next = null;
        while (cur1 != null && cur2 == null) {
            if (cur1.val < cur2.val) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;  //
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

//    next = cur2.next;
//    pre.next = cur2;
//    cur2.next = cur1;
//    pre = cur2;
//    cur2 = next;



}
