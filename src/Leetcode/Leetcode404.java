package Leetcode;

public class Leetcode404 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sum(root);
        return sum;
    }

    public void sum (TreeNode root) {
        if(root == null) {
            return;
        }
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            sum += root.left.val;
        }
        sum(root.left);
        sum(root.right);
    }


    }
