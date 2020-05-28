package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode145 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        stack1.push(root);
        while(!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }
        while(!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
        return res;
    }
    }
