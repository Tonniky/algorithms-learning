package ZCYCodingGuide.listNode;

public class removeByRatio {

    public class ListNode {
        public int val;
        public ListNode (int data) {
            this.val = data;
        }
    }

    public ListNode removeByRatio(ListNode head, int a, int b) {
        if (head == null || a < 1 || a > b) {
            return head;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int index = Math.ceil((double)(a * len) / (double) b);
        if (n == 1) {
            head = head.next;
        }

        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

}
