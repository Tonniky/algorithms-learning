package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class findBottomLeftValue513 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data) {
            this.val = data;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int res = root.val;
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res = node.val;
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
        return res;
    }
    int m = Integer.MAX_VALUE;
    }
