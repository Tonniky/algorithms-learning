package Leetcode;

public class Leetcode222 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    public int count = 0;
    public int countNodes(TreeNode root) {
        count(root);
        return count;
    }

    public void count(TreeNode root) {
        if(root != null) {
            count++;
        } else {
            return;
        }
        count(root.left);
        count(root.right);
    }

    //简化一下

    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }


    }
