package ZCYCodingGuide.binaryTree;

public class Contains {

    public class TreeNode {
        public int val;
        public TreeNode (int data) {
            this.val = data;
        }
        public TreeNode left;
        public TreeNode right;
    }

    public boolean contains (TreeNode t1, TreeNode t2) {
        return isCheck(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }


    public boolean isCheck (TreeNode t3, TreeNode t4) {
        if (t4 == null) {
            return true;
        }
        if (t3 == null || t3.val != t4.val) {
            return false;
        }
        return isCheck(t3.left, t4.left) && isCheck(t3.right, t4.right);
    }
}
