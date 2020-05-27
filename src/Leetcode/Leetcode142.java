package Leetcode;

import java.util.HashMap;

public class Leetcode142 {
    public class ListNode{
        public int val;
        public ListNode next;
        public ListNode (int data) {
            this.val = data;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode node = head;
        HashMap<ListNode,Integer> map = new HashMap<>();
        int n = 0;
        while(node !=null) {
            if(map.containsKey(node)) {
               return node;
            }
            map.put(node,n++);
            node = node.next;
        }
        return null;
    }
    }
