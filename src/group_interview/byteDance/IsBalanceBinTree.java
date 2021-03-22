package group_interview.byteDance;

// 是否是平衡二叉树
public class IsBalanceBinTree {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }

    public boolean isBalanceBinTree(TreeNode tree) {
        if (tree == null) {
            return true;
        }
        if (Math.abs(getTreeDeepth(tree.left) - getTreeDeepth(tree.right)) > 1) {
            return false;
        }
        return isBalanceBinTree(tree.right) && isBalanceBinTree(tree.left);
    }

    public int getTreeDeepth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        return Math.max(getTreeDeepth(tree.left), getTreeDeepth(tree.right)) + 1;
    }
}
