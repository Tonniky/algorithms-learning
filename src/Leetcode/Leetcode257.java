package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    ArrayList<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        bfs(root, "");
        return res;
    }

    public void bfs (TreeNode root, String temp) {
        if (root != null) {
            temp += Integer.toString(root.val);
        if(root.left == null && root.right == null) {
            res.add(temp);
        } else {
        temp += "->";
        bfs(root.left, temp);
        bfs(root.right, temp);
    }
        }
    }
    }
