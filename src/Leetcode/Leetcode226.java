package Leetcode;

public class Leetcode226 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    TreeNode newRoot;
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        newRoot = new TreeNode(root.val);
        changeTree(root, newRoot);
        return newRoot;
    }

    public void changeTree (TreeNode root, TreeNode newRoot) {
        if (root != null) {
            newRoot = root;
        }
        changeTree(root.left, newRoot.right);
        changeTree(root.right, newRoot.left);
    }

    public TreeNode invertTree1(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    }
