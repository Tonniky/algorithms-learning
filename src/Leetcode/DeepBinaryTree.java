package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DeepBinaryTree {
    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    //
    public List<List<TreeNode>> findTreeNode(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(node);
        List<List<TreeNode>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.peek();
                res.add(temp);
                if (cur.left != null) {
                    queue.push(cur.left);
                }
                if (cur.right != null) {
                    queue.push(cur.right);
                }
            }
        }
        return res;
    }


    //判断是否是平衡二叉树
    public boolean deepthBinaryTree(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        if (Math.abs(dpBTree(treeNode.right) - dpBTree(treeNode.left)) > 1) {
            return true;
        }
        return deepthBinaryTree(treeNode.left) && deepthBinaryTree(treeNode.right);
    }

    public int dpBTree(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(dpBTree(treeNode.right), dpBTree(treeNode.left)) + 1;
    }
}
