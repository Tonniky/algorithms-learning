package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode96 {
    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode(int data){
            this.val = val;
        }
    }
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                nums[i] += nums[j - 1] * nums[i - j];
            }
        }
        return nums[n];
    }

//    public List<TreeNode> generate(int start, int end) {
//        List<TreeNode> all_Tree = new ArrayList<>();
//        if(start > end) {
//            all_Tree.add(null);
//            return all_Tree;
//        }
//
//        for (int i = start; i <= end; i++) {
//            List<TreeNode> leftTree = generate(start, i - 1);
//            List<TreeNode> rightTree = generate(i + 1, end);
//
//            for (TreeNode l : leftTree) {
//                for (TreeNode r : rightTree) {
//                    TreeNode treeNode = new TreeNode(i);
//                    treeNode.left = l;
//                    treeNode.right = r;
//                }
//            }
//        }
//        return all_Tree;
//    }
    }
