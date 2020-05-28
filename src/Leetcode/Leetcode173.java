package Leetcode;

import java.util.ArrayList;

public class Leetcode173 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    class BSTIterator {
        ArrayList<Integer> nodeSorted;
        int index;

        public BSTIterator(TreeNode root) {
            this.nodeSorted = new ArrayList<>();
            this.index = -1;
            this._inorder(root);
        }

        private void _inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            this._inorder(root.left);
            this.nodeSorted.add(root.val);
            this._inorder(root.right);
        }

        public int next() {
            return this.nodeSorted.get(++this.index);
        }

        public boolean hasNext() {
            return this.index + 1 < this.nodeSorted.size();
        }
    }

}
