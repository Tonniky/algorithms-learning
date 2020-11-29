package Leetcode;
import java.util.*;
public class OrderSearchBinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    // 迭代写中序遍历二叉树
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> orderSearchBinaryTree(TreeNode root) {
        orderBTree(root);
        return res;
    }

    public  void orderBTree(TreeNode root) {
        if (root.left != null) {
            orderBTree(root.left);
        }
        res.add(root.val);

        if (root.right != null) {
            orderBTree(root.right);
        }
    }

    //非递归方式遍历二叉树
    public  static List<Integer> orderSearchBinaryTree2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                res.add(temp.val);
                root = root.right;
            }
        }
        return res;
    }
}

