package group_interview.baidu;

public class isCricle {
    public class ListNode {
        public int val;

        public ListNode (int data) {
            this.val = data;
        }
        public ListNode next;
    }

    public boolean isCricle(ListNode root) {
        if (root == null) {
            return false;
        }

        ListNode fast = root;
        ListNode slow = root;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
