package group_interview.baidu;

public class findCiclePosition {

    public class ListNode {
        int val;

        public ListNode (int data) {
            this.val = data;
        }

        ListNode next;
    }


    public ListNode findCirclePosition(ListNode root) {
        if (root == null) {
            return null;
        }

        ListNode n1 = root;
        ListNode n2 = root;

        while (n2.next != null && n2.next.next != null) {
            n1 = root.next;
            n2 = root.next.next;
            if (n1 == n2) {
                break;
            }
        }
        if (n2.next == null || n2.next.next == null) {
            return null;
        }
        n2 = root;
        while (n1 != n2) {
            n2 = n2.next;
            n1 = n1.next;
        }
        return n2;
    }
}
