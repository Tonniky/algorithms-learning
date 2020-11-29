package Leetcode;
import java.util.*;

public class printTree655 {
    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode (int data) {
            this.val = data;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int h = getHeight(root);
        String[][] arr = new String[h][(1 << h) - 1];
        for (String[] res: arr) {
            Arrays.fill(res, "");
        }
        partition(arr, root, 0, 0, arr[0].length);
        List<List<String>> out = new ArrayList<>();
        for (String[] res: arr) {
            out.add(Arrays.asList(res));
        }
        return out;
    }

    public void partition(String[][] arr,TreeNode node, int h, int l, int r) {
        if (node == null)
            return ;
        arr[h][(l + r) / 2] = "" + node.val;
        partition(arr, node.left, h + 1, l, (l + r)/2);
        partition(arr, node.right, h + 1, (l + r + 1) /2, r);
    }


    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    }
