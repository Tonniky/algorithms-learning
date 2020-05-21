package Leetcode;

public class Leetcode112 {
    public class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    int cur = 0;
    int sum = 0;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if(root.left == null || root.right == null)
            return sum == 0 ? true : false;
        return hasPathSum(root.left, sum) || hasPathSum(root.right,sum);
    }
//
//    public boolean isExits(TreeNode root, int sum) {
//        if (root == null) {
//            return false;
//        }
//        sum += root.val;
//        isExits(root.left,sum);
//    }
    }
