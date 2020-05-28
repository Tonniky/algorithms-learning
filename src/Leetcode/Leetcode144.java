package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode144 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
           return null;
        }
        preOrder(root);
        return res;
    }
    public void preOrder(TreeNode root) {
        res.add(root.val);
        while(root.left != null) {
            preOrder(root.left);
        }
        while(root.right != null) {
            preOrder(root.right);
        }
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (root.right != null) {
                stack.add(root.right);
            }
            if (root.left != null) {
                stack.add(root.left);
            }
        }
        return list;
    }


    }
