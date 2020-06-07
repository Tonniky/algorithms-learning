package Leetcode;

import java.util.HashMap;

public class Leetcode337 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money, rob(root.right) + rob(root.left));
    }

    public int rob1(TreeNode root) {
        HashMap<TreeNode, Integer> temp = new HashMap<>();
        return robber (root,temp);
    }

    public int robber(TreeNode root, HashMap<TreeNode, Integer> t) {
        if(root == null) {
            return 0;
        }
        if (t.containsKey(root)) {
            return t.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += robber(root.left.left, t) + robber(root.left.right, t);
        }
        if (root.right != null) {
            money += robber(root.right.left, t) + robber(root.right.right, t);
        }
        int res = Math.max(robber(root.right, t) + robber(root.left, t), money);
        return res;
    }




    }
