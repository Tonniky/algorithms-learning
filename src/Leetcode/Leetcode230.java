package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode230 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    List<Integer> out = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, out);
        return out.get(k - 1);
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right, res);
    }
    }
