package Leetcode;

public class IsBalancedBTree {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    public boolean isBalancedBTree(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        if (Math.abs(deepthTree(treeNode.right) - deepthTree(treeNode.left)) > 1 ) {
            return false;
        }
        return isBalancedBTree(treeNode.left) && isBalancedBTree(treeNode.right);
    }

    public int deepthTree(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(deepthTree(treeNode.left), deepthTree(treeNode.right)) + 1;
    }
}
