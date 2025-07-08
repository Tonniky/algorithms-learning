package hot100;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;
import sun.reflect.generics.tree.LongSignature;

import java.util.ArrayList;
import java.util.List;

public class isPalindrome {
    private class ListNode {
        private int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    private static boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }




}
