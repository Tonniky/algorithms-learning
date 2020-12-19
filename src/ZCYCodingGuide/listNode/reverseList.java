package ZCYCodingGuide.listNode;

public class reverseList {

    public class ListNode {
        public int val;
        public ListNode (int data) {
            this.val = data;
        }
        public ListNode next;
    }

    public ListNode reverseList(ListNode node) {
        if (head == null || head.next == null) {
            return node;
        }

        ListNode preNode = null;
        ListNode nextNode = null;
        while (node != null) {
            nextNode = node.next;
            cur.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return pre;
    }
}
