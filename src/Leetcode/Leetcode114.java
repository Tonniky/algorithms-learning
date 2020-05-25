package Leetcode;

public class Leetcode114 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    public void flatten(TreeNode root) {
        while(root != null) {
            if (root.left != null) {
                root = root.right; //考虑下一个节点
            }else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
    }
