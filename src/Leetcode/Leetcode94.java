package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode94 {
    public class TreeNode  {
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode(int data) {
            this.val = data;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        order(root, res);
        return res;
    }

    public void order(TreeNode root, List<Integer> res) {
        order(root.left,res);
        res.add(root.val);
        order(root.right,res);
    }


    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                stack.push(root.right);
            }
        }
        return res;
    }

    public List < Integer > inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


    }
