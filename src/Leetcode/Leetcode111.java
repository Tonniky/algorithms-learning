package Leetcode;

public class Leetcode111 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if((root.left == null) && (root.right == null))
            return 1;
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(min_depth,minDepth(root.left));
        }
        if (root.right != null) {
            min_depth = Math.min(min_depth, minDepth(root.right));
        }
        return 1 + min_depth;
    }
    }
