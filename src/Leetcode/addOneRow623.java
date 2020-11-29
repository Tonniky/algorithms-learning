package Leetcode;
import java.util.*;

public class addOneRow623 {

    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode(int data) {
            this.val = data;
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        insertV(root, v, 1, d);
        return root;
    }

    public void insertV(TreeNode root, int v, int n, int d) {
        if (root == null) {
            return;
        }
        if(n == d - 1) {
            TreeNode f = root.left;
            root.left = new TreeNode(v);
            root.left.left = f;
            f = root.right;
            root.right = new TreeNode(v);
            root.right.right = f;
        } else {
            // 实际上也完成了层序遍历。
            insertV(root.left, v, n + 1, d);
            insertV(root.right, v, n + 1, d);
        }
    }

    //用层序遍历的方式去解答问题

    public TreeNode addOneRow2(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        int depth = 1;
        deque.addLast(root);
        while(deque.isEmpty() && depth < d) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = deque.pollFirst();
                if (depth != d - 1) {
                    if (temp.left != null) deque.addLast(temp.left);
                    if (temp.right != null) deque.addLast(temp.right);
                } else {
                    TreeNode tempL = temp.left;
                    TreeNode tempR = temp.right;
                    TreeNode leftV = new TreeNode(v);
                    TreeNode rightV = new TreeNode(v);
                    temp.left = leftV;
                    temp.right = rightV;
                    leftV.left = tempL;
                    rightV.right = tempR;
                }
            }
            depth++;
        }
        return root;
    }
    }
