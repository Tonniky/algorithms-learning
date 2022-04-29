package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class bstFromPreorder1008 {

    //  Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    // bstFromPreorder
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        int[] inorder = new int[len];
        System.arraycopy(preorder, 0, inorder, 0, len);
        Arrays.sort(inorder);

        // 将值写入index中
        int index = 0;
        for (Integer value : inorder) {
            hashMap.put(value, index);
            index++;
        }
        return dfs(0, len - 1, 0, len - 1, preorder, hashMap);
    }

    // dfs
    public TreeNode dfs(int preLeft, int preRight, int inLeft, int inRight, int[] preorder, Map<Integer, Integer> hashMap) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = hashMap.get(pivot);
        root.left = dfs(preLeft + 1, pivotIndex - inLeft + preLeft,
                inLeft, pivotIndex - 1, preorder, hashMap);
        root.right = dfs(pivotIndex - inLeft + preLeft + 1, preRight,
                pivotIndex + 1, inRight, preorder, hashMap);
        return root;

//        root.left = dfs(preLeft + 1, preLeft + pivotIndex - inLeft,
//                inLeft, pivotIndex - 1, preorder, hashMap);
//        root.right = dfs(preLeft + pivotIndex - inLeft + 1, preRight, pivotIndex + 1,
//                inRight,preorder, hashMap);
    }

    public TreeNode bstFromPreorder1(int[] preorder) {
          int len = preorder.length;
          Map<Integer, Integer> indexMap = new HashMap<>();
          int[] inorder = new int[len];
          System.arraycopy(preorder, 0, inorder,0, len);
          Arrays.sort(inorder);
          for (int i = 0; i < len; i++) {
              indexMap.put(inorder[i],i);
          }
          return dfs(preorder, indexMap, 0, len - 1, 0, len - 1);
      }

      public TreeNode dfs(int[] preorder, Map<Integer,Integer> map, int preLeft, int preRight, int inLeft, int inRight) {
          if (preRight > preLeft || inRight > inLeft) {
              return null;
          }
          int rootIndex = preorder[preLeft];
          int inorderIndex = map.get(rootIndex);
          TreeNode root = new TreeNode(rootIndex);
          root.left = dfs(preorder, map, preLeft + 1, preLeft + inorderIndex - inLeft, inLeft, inorderIndex - 1);
          root.right = dfs(preorder, map, preLeft + inorderIndex - inLeft + 1, preRight, inorderIndex + 1, inRight);
          return root;
      }

    }
