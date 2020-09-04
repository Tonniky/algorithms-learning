package Leetcode;


public class lowestCommonAncestor1659 {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < p.val) {
            root = lowestCommonAncestor2(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val){
            root = lowestCommonAncestor2(root.left, p, q);
        }
        return root;
    }



    }
