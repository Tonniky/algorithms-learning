package ZCYCodingGuide.listNode;

public class removeLastKthNode {
    public class ListNode {
        public int val;
        public ListNode (int data) {
            this.val = data;
        }
    }

    public ListNode removeLastKthNode(ListNode node, int k) {
        if (node == null || k < 1) {
            return null;
        }
        ListNode cur = node;
        while (cur1 != null) {
            k--;
            cur1 = cur1.next;
        }
        if (k == 0) {
            cur = node.next;
            return cur;
        }
        if (k < 0) {
            cur = node;
            while (k != 0) {
                cur = cur.next;
                k++;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
