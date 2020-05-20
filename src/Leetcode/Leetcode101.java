package Leetcode;

public class Leetcode101 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data){
            this.val = data;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return compare(root, root);
    }

    public boolean compare(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        if(t1.val != t2.val) {
            return false;
        }
        return compare(t1.left, t2.right) && compare(t1.right, t2.left);
    }
    }
