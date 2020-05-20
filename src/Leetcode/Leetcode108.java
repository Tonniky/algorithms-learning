package Leetcode;

public class Leetcode108 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data) {
            val = data;
        }
    }
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return help(0,nums.length - 1);
    }

    public TreeNode help(int left, int right) {
        if(left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(left, mid - 1);
        root.right = help(mid + 1, right);
        return root;
    }
    }
