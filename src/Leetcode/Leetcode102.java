package Leetcode;

import java.util.*;

public class Leetcode102 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data) {
            this.val = data;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if ( root != null)
            q.add(root);
        while(!q.isEmpty()) {
            int currentLevelSize = q.size();
            List<Integer> point = new ArrayList<>();
            for (int i = 1; i <= currentLevelSize; i++) {
                TreeNode node = q.poll();
                point.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ret.add(point);
        }
        return ret;
    }


    public void inOrderSort(TreeNode root,List<List<Integer>> res) {

    }

    }
