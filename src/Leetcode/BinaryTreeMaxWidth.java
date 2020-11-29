package Leetcode;
import java.util.*;

//pdd 一面面试题 2020/10/21
public class BinaryTreeMaxWidth {
    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode(int data) {
            this.val = data;
        }
    }


    public int BinaryTreeMaxWidth(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int res = 0;
        stack.push(treeNode);
        while(!stack.isEmpty()) {
            res = res > stack.size() ? res : stack.size();
            for(int i = 0; i < stack.size(); i++) {
                TreeNode list = stack.pop();
                if (list.left != null) {
                    stack.push(list.left);
                }
                if (list.right != null) {
                    stack.push(list.right);
                }
            }
        }
        return res;
    }

}
