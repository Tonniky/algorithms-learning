package Leetcode;
import java.util.*;
public class findDuplicateSubtrees652 {
    public class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode (int data) {
            this.val = data;
        }
    }

    Map<String, Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<String,Integer>();
        res = new ArrayList<TreeNode>();
        findTree(root);
        return res;
    }

    public  String findTree(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String temp = root.val + "," + findTree(root.left) + "," + findTree(root.right);
        map.put(temp,map.getOrDefault(temp, 0) + 1);
        if (map.get(temp) == 2) {
            res.add(root);
        }
        return temp;
    }




}
