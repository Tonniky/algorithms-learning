package ZCYCodingGuide.binaryTree;

import java.util.ArrayList;
import java.util.*;

public class posOrderUnRecur {
    public class TreeNode {
        public int val;
        public TreeNode (int data) {
            this.val = data;
        }
        public TreeNode left;
        public TreeNode right;
    }

    public List<TreeNode> posOrderUnRecre(TreeNode treeNode) {
        if (treeNode == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(treeNode);
        while(!stack1.isEmpty()) {
            treeNode = stack1.pop();
            stack2.push(s2);
            if (treeNode.left != null) {
                stack1.push(treeNode);
            }
            if (treeNode.right != null) {
                stack1.push(treeNode);
            }
        }
        List<TreeNode> res = new ArrayList<>();
    while (!stack2.isEmpty()) {
        res.add(stack2.pop());
        }
        return res;
    }

}
