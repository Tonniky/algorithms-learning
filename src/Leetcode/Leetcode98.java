package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode98 {
    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode(int data) {
            this.val = data;
        }
    }
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        double min = - Double.MAX_VALUE;
        while(root != null || !stack.isEmpty()){
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
//                if(min >= root.val)
//                    return false;
//                min = root.val;
                res.add(root.val);
                root = root.right;
            }
        }
        boolean flag = true;
        for (Integer index :res) {
            if(index > min){
                min = index;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
