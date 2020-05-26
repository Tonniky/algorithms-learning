package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode129 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    public int sumNumbers(TreeNode root) {
        return currentSum(root, 0);
    }
    public int currentSum(TreeNode root,int i) {
        if(root == null) {
            return 0;
        }
        int temp = i * 10 + root.val;
        if(root.left == null && root.right == null) {
            return temp;
        }
        return currentSum(root.left,temp) + currentSum(root.right,temp);
    }
    }
