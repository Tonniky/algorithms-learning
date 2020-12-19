package ZCYCodingGuide.listNode;


public class removeLastKthPnode {
    public class DoubleNode {
        public int val;
        public DoubleNode next;
        public DoubleNode pre;
        public DoubleNode (int data) {
            this.val = data;
        }
    }

    public DoubleNode removeLasDoubleNode(DoubleNode node, int k) {
        if (node == null || k < 0) {
            return null;
        }
        DoubleNode cur = node;
        if (cur != null) {
            cur = cur.next;
            k--;
        }

        if (k == 0) {
            cur = cur.next;
            cur.pre = null;
        }

        if (k < 0) {
            cur = node;
            while (k != 0) {
                cur = cur.next;

                DoubleNode cur2 = cur.next.next;
                cur.next = cur2;
                if (cur2 != null) {
                    cur2.pre = cur;
                }
            }
        }
        return node;
    }

}
