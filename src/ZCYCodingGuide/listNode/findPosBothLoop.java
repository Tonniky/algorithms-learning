package ZCYCodingGuide.listNode;

public class findPosBothLoop {

    public class ListNode {
        public int val;
        public ListNode (int data) {
            this.val = data;
        }
    }

    public ListNode findPosBothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        Node cur1 = head1;
        Node cur2 = head2;
        if (loop1 == head2) {
            int len1 = 0, len2 = 0;
            while (cur1 != loop1) {
                len1++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                len2++;
                cur2 = cur2.next;
            }
            cur1 = len1 > len2 ? head1 : head2;
            cur2 = len1 > len2 ? head2 : head1;
            int dis = Math.abs(len1 - len2);
            while (dis != 0) {
                cur1 = cur1.next;
            }

            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (loop1 == loop2) {
                    return loop1;
                }

            }
        }
    }
}
