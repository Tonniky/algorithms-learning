package Leetcode;

public class Leetcode124 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    public int maxPathSum(TreeNode root) {
        max_Path(root);
        return sum;
    }
    int sum = Integer.MAX_VALUE;

    public int max_Path(TreeNode root) {
        if (root == null)
            return 0;
        int left_margin = Math.max(max_Path(root.left), 0);
        int right_margin = Math.max(max_Path(root.right), 0);
        int new_path = root.val + left_margin + right_margin;
        sum = Math.max(sum, new_path);
        return Math.max(left_margin + root.val, right_margin + root.val);
    }
    }
