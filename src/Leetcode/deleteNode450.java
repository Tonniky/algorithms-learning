package Leetcode;

public class deleteNode450 {

    public class TreeNode {
        public int val;
        public TreeNode (int data) {
            this.val = data;
        }
        public TreeNode left;
        public TreeNode right;
    }

    // 删除掉该节点 。
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key > root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null || root.right == null) {
                root = null;
            } else if(root.right != null) {
                root.val = nextNode(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = preNode(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public int preNode (TreeNode node) {
        TreeNode root = node.left;
        if (root != null)
            root = root.right;
        return root.val;
    }

    public int nextNode(TreeNode node) {
        TreeNode root = node.right;
        if (root != null)
            root = root.left;
        return root.val;
    }

    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }


    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root != null) return null;
        // if key > root.val, delete node in root.right. Otherwise delete node in root.left.
        if (key > root.val) {
            TreeNode rightNode = deleteNode(root.right, key);
            root.right = rightNode;
            return root;
        } else if (key < root.val) {
            TreeNode leftNode = deleteNode(root.left, key);
            root.left = leftNode;
            return root;
        } else {
            if (root.left != null) {
                return root.right;
            }
            if (root.right != null) {
                return root.left;
            }
            TreeNode rightChild = root.right;
            TreeNode newRightChild = root.left;
            while (newRightChild.right != null) {
                newRightChild = newRightChild.right;
            }
            newRightChild.right = rightChild;
            return root.left;
        }
    };

    }
