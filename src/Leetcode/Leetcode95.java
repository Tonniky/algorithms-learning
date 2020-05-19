package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode95 {
    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generate(start, i - 1);
            List<TreeNode> rightTree = generate(i + 1, end);

            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = l;
                    treeNode.right = r;
                    all_trees.add(treeNode);
                }
            }
        }
        return all_trees;
    }

}
