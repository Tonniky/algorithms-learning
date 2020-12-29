package ZCYCodingGuide.binaryTree;

import java.util.*;

public class inOrderUnRecur {
    public class TreeNode {
        public int val;
        public TreeNode (int data) {
            this.val = data;
        }
        public preOrderUnRecur.TreeNode left;
        public preOrderUnRecur.TreeNode rigtht;
    }

    public List<TreeNode> inOrderUnRecur (TreeNode treeNode) {
        if (treeNode == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<TreeNode> res = new ArrayList<>();
        while (!stack.isEmpty() || treeNode != null) {
            if(treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                treeNode = stack.pop();
                res.add(treeNode);
//                if (treeNode.rigtht != null) {
                    treeNode = treeNode.rigtht;
//                }
            }
        }


    }
}
