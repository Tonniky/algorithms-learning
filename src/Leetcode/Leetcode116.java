package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

//    public Node connect(Node root) {
//
//    }

    public Node connect(Node root) {
        if (root == null) {
            return new Node();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Node>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Node> temp = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                // 最关键的一步
                if (i < len - 1) {
                    cur.next = queue.peek();
                }

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return root;
    }



}
