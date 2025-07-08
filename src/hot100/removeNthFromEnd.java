package hot100;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import javax.swing.*;

public class removeNthFromEnd {

    private static class ListNode {
        private int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static void main(String[] args) {

    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        int len = getLength(head);
        for (int i = 1; i < len - n + 1; i++) {
            cur = cur.next;
        }
        return dummyNode.next;
    }

    private static int getLength(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

}
