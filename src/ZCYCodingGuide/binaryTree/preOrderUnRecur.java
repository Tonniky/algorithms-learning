package ZCYCodingGuide.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class preOrderUnRecur {
    public class TreeNode {
        public int val;
        public TreeNode (int data) {
            this.val = data;
        }
        public TreeNode left;
        public TreeNode rigtht;
    }

    public List<TreeNode> preOrderUnRecur(TreeNode treeNode) {
        if (treeNode == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> res = new ArrayList<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp);
            if (temp.rigtht != null) {
                stack.push(temp.rigtht);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return res;
    }
}
