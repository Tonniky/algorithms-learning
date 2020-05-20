package Leetcode;

public class Leetcode109 {
    public class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data) {
            this.val = data;
        }
    }

    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int data) {
            this.val = data;
        }
    }
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        int size = this.findSize(head);
        this.head = head;
        return convertTreeNode(0, size - 1);
    }

    public TreeNode convertTreeNode(int l, int r) {
        if ( l > r) {
            return null;
        }
        int mid = (l + r) / 2;

        TreeNode node = convertTreeNode(l, mid - 1);

        TreeNode root = new TreeNode(head.val);
        root.left = node;
        this.head = this.head.next;
        root.right = convertTreeNode(mid + 1, r);
        return root;
    }

    public int findSize(ListNode head){
        ListNode st = head;
        int n = 1;
        while (st.next != null) {
            n++;
            st = st.next;
        }
        return n;
    }
    }
