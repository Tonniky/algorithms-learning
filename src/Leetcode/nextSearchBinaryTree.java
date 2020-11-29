package Leetcode;
import java.util.*;
public class nextSearchBinaryTree {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }

    public List<Integer> nextSearchBinaryTree(TreeNode treeNode) {
        if (treeNode != null) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(treeNode);
        while(!s1.isEmpty()) {
            TreeNode head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }
        while(!s2.isEmpty()) {
            res.add(s2.pop().val);
        }
        return res;
    }
}
