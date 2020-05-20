package Leetcode;

public class Leetcode100 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data) {
            this.val = data;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && p == null)
            return true;
        if(p == null && p != null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }



    }
