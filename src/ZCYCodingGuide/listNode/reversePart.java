package ZCYCodingGuide.listNode;

public class reversePart {

    public class ListNode {
        public int val;
        public ListNode (int data) {
            this.val = data;
        }
        public ListNode next;
    }

    public ListNode reversePart (ListNode node, int from, int to) {
        int len;
        ListNode fPre = null;
        ListNode tNext = null;
        while (node != null) {
            len++;
            fPre = from - 1 == len ? node : fPre;
            tNext = to + 1 == len ? node : tNext;
            node = node.next;
        }

        if (from >= to || from < 1 || to > len) {
            return node;
        }

        ListNode node1 = fPre == null ? node : fPre.next;
        Node node2 = node1.next;
        ListNode nextNode = null;
        node1.next = tNext;
        while (node2 != tNext) {
            nextNode = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = nextNode;
        }

        if (fPre != null) {
            node1.next = fPre;
            return node;
        }
        return node1;
    }

}
