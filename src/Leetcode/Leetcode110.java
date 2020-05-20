package Leetcode;

public class Leetcode110 {
    public class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data) {
            this.val = data;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(height(root.right) - height(root.left)) < 2 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if(root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    }
