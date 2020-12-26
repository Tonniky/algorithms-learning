package ZCYCodingGuide.binaryTree;

public class Genetate {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int data) {
            this.val = data;
        }
    }

    public TreeNode generate(int[] sortArr) {
        if (sortArr == null) {
            return null;
        }

        return sort(sortArr, 0 , sortArr.length - 1);
    }


    public TreeNode sort(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode head = new TreeNode(arr[mid]);
        // 左右节点进行晋级
        head.left = sort(arr, start, mid - 1);
        head.right = sort(arr, mid + 1, end);
        return head;
    }
}
