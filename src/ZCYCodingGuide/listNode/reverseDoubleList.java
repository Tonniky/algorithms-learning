package ZCYCodingGuide.listNode;

public class reverseDoubleList {

    public class DoubleNode{
        public int val;
        public DoubleNode(int data) {
            this.val = data;
        }
        public DoubleNode last;
        public DoubleNode next;
    }


    public DoubleNode reverseDoubleList (DoubleNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        DoubleNode preNode;
        DoubleNode nextNode;

        while (node != null) {
            nextNode = node.next;
            cur.next = preNode;
            pre.last = cur;
            pre = node;
            node = nextNode;
        }
        return preNode;
    }
}
