package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode104 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data) {
            val = data;
        }
    }
    public int maxDepth(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        int n = 0;
        if ( root != null)
            q.add(root);
        while(!q.isEmpty()) {
            int currentLevelSize = q.size();
            n++;
            List<Integer> point = new ArrayList<>();
            for (int i = 1; i <= currentLevelSize; i++) {
                TreeNode node = q.poll();
                point.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ret.add(point);
        }
        return n;
    }
}
