package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head.next == null) {
            return head;
        }
        ListNode listNode = new ListNode(0);
        List<Integer> arr = new ArrayList<>();
        while(head != null) {
            int value = head.val;
            arr.add(value);
        }
        for(int i = arr.size()-k ; i < arr.size(); i++) {
            listNode.val = arr.get(i);
            listNode = listNode.next;
        }
        for(int i = 0; i< arr.size()-k; k++) {
            listNode.val = arr.get(i);
            listNode = listNode.next;
        }
        return listNode;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        ListNode old_value = head;
        int n ;   //用来统计长度
        for(n = 1; old_value.next != null; n++)
            old_value = old_value.next;
        old_value.next =head;  //首尾想接，成环。
        ListNode new_node = head;
        for(int i = 0 ; i < n - k % n -1; i++)
            new_node = new_node.next;
        ListNode new_head = new_node.next;  //新的头部
        new_node.next = null; //断掉环，将最后的节点指向null
        return new_head;
    }



}
