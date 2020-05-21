package Leetcode;

import java.util.*;

public class Leetcode113 {
    public class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> temp = new ArrayDeque<>();
    public void dfs(TreeNode root, int sum) {
        sum -= sum - root.val;
        temp.addLast(root.val);
        if(sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(temp));
            return ;
        }
        if(root.left != null) {
            dfs(root.left, sum);
            temp.removeLast();
        }
        if(root.right != null)
            dfs(root.right, sum);
            temp.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null)
            dfs(root, sum);
            return res;
    }
}
