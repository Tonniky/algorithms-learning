package ZCYCodingGuide.listNode;

public class findPosNoLoop {

    public class ListNode{
        public class val;
        public ListNode (int data){
            this.val = data;
        }
        public ListNode next;
    }


    public ListNode findPosNoLoop (ListNOde node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }

        ListNode head1 = node1;
        ListNode head2 = node2;
        int len1 = 0, len2 = 0;

        while(head1.next != null) {
            len1++;
            head1 = head1.next;
        }

        while(head2.next != null) {
            len2++;
            head2 = head2.next;
        }

        if (head1 != head2) {
            return null;
        }

        int lenDis = Math.abs(len1- len2);
        while (lenDis > 0) {
            if (len1 > len2) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }

        return head2;

    }
}
