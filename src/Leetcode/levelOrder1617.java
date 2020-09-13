package Leetcode;

import java.util.*;

public class levelOrder1617 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (root.left != null) {
                    deque.addLast(root.right);
                }
                if (root.right !=null) {
                    deque.addLast(root.right);
                }
                temp.add(deque.removeFirst().val);
            }
            res.add(temp);
        }
        return res;
    }
    }
