package Leetcode;
import java.util.*;
public class binaryTreeCengxubianli {
    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode(int data) {
            this.val = data;
        }
    }
    //二叉树的层序遍历
    public List<List<Integer>> binaryTreeCengxubianli(TreeNode treeNode) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (treeNode == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(treeNode);
        while(!stack.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len = stack.size();
            for (int i = 0; i < len; i++) {
                TreeNode root = stack.pop();
                temp.add(root.val);
                if (root.left != null) {
                    stack.push(root.left);
                }
                if (root.right != null) {
                    stack.push(root.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
