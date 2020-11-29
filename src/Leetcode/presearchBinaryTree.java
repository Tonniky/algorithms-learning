package Leetcode;
import java.util.*;
public class presearchBinaryTree {
    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int value;
        public TreeNode (int data) {
            this.value = data;
        }
    }
    //递归的方式去得到值
    List<Integer> res = new ArrayList<>();
    public List<Integer> presearchBinaryTree (TreeNode treeNode) {
        res.add(treeNode.value);

        if (treeNode.left != null)  {
            presearchBinaryTree(treeNode.left);
        }

        if (treeNode.right != null) {
            presearchBinaryTree(treeNode.right);
        }
        return res;
    }

    //使用非递归的方式去前序遍历二叉树

    public List<Integer> presearchBinaryTree2 (TreeNode treeNode) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(treeNode);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.value);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return result;
    }
}
