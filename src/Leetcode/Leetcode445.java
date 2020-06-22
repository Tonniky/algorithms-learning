package Leetcode;

import java.util.Stack;

public class Leetcode445 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int data) {
            this.val = data;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> list1 = new Stack<>();
        while(l1.next != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> list2 = new Stack<>();
        while(l2.next != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode res = new ListNode(0);
        while (list1 != null || list2 != null || carry != 0) {
            int a = list1.isEmpty() ? 0 : list1.pop();
            int b = list2.isEmpty() ? 0 : list2.pop();
            carry = (a + b + carry) / 10;
            int temp = (a + b + carry) % 10;
            ListNode listNode = new ListNode(temp);
            listNode.next = res;
            res = listNode;
        }
        return res;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty()? 0: stack1.pop();
            sum += stack2.isEmpty()? 0: stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }


    }
