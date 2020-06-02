package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode234 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode (int data) {
            this.val = data;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = res.size() - 1;
        while(left < right) {
            if (!res.get(left).equals(res.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    
    }
