package hot100;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class getIntersetionNode {
    public static void main(String[] args) {

    }

    private class ListNode {
        private int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    private static ListNode getIntersetionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    private static ListNode getIntegesetionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }




}
