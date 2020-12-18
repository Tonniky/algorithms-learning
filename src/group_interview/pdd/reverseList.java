package group_interview.pdd;

public class reverseList {
    public  class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int data) {
            this.val = data;
        }
    }

    public ListNode reverseList(ListNode listNode) {
        ListNode pre = null;
        ListNode next = null;
        while (listNode != null) {
            next = listNode.next;
            listNode = next.next;
            pre = listNode;
            listNode = next;
        }
        return pre;
    }
}
