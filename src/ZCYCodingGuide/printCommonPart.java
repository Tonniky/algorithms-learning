package ZCYCodingGuide;

import java.util.*;

public class printCommonPart {


    public class ListNode {
        public int val;
        public ListNode (int data) {
            this.val = data;
        }
        public ListNode next;
    }

    public List<Integer> printCommonsList(ListNode head1, ListNode head2) {
        List<Integer> res = new ArrayList<>();
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                head1 = head1.next;
                head2 = head2.next;
                res.add(head1.val);
            }
        }
        return res;
    }
}
