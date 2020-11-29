package Leetcode;

public class DeepBinaryTree {
    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    //判断是否是平衡二叉树
    public boolean deepthBinaryTree(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        if(Math.abs(dpBTree(treeNode.right) - dpBTree(treeNode.left)) > 1) {
            return true;
        }
        return deepthBinaryTree(treeNode.left) && deepthBinaryTree(treeNode.right);
    }

    public int dpBTree(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        return Math.max(dpBTree(treeNode.right),dpBTree(treeNode.left)) + 1;
    }
}
