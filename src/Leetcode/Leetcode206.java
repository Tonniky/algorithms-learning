package Leetcode;

import java.io.UnsupportedEncodingException;

public class Leetcode206 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode (int data) {
            this.val = data;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String srcString = "测试数据\b";
        String utf2GbkString = new String(srcString.getBytes("UTF-8"),"GBK");
        System.out.println("UTF-8转换成GBK："+utf2GbkString);
        String utf2Gbk2UtfString = new String(utf2GbkString.getBytes("GBK"),"UTF-8");
        System.out.println("UTF-8转换成GBK再转成UTF-8："+utf2Gbk2UtfString);
    }
}
