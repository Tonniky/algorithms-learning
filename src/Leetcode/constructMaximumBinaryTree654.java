package Leetcode;

public class constructMaximumBinaryTree654 {

    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode(int data) {
            this.val = data;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return consMax(nums, 0, nums.length);
    }

    public TreeNode consMax(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int temp = findMax(nums, left, right);
        TreeNode node = new TreeNode(nums[temp]);
        node.left = consMax(nums, left, temp);
        node.right = consMax(nums, temp + 1, right);
        return node;
    }

    public int findMax(int[] nums, int left, int right) {
        int res = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[res]) {
                res = i;
            }
        }
        return res;
    }

//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        return consMax(nums, 0, nums.length - 1);
//    }
//
//    public TreeNode consMax(int[] nums, int left, int right) {
//        if (left > right) {
//            return null;
//        }
//        int temp = findMax(nums, left, right);
//        TreeNode node = new TreeNode(nums[temp]);
//        node.left = consMax(nums, left, temp - 1);
//        node.right = consMax(nums, temp + 1, right);
//        return node;
//    }
//
//    public int findMax(int[] nums, int left, int right) {
//        int res = left;
//        for (int i = left; i <= right; i++) {
//            if (nums[i] > nums[res]) {
//                res = i;
//            }
//        }
//        return res;
//    }

    }
