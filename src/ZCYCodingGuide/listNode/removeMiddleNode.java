package ZCYCodingGuide.listNode;

public class removeMiddleNode {
    public class ListNode {
        public int val;
        public ListNode (int data) {
            this.val = data;
        }
        public ListNode next;
    }

    public ListNode removeMiddleNode (ListNode node) {
        if (node == null || node.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        ListNode pre = node;
        ListNode cur = node.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = cur.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
