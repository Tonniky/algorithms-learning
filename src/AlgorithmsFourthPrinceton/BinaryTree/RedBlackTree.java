//package AlgorithmsFourthPrinceton.BinaryTree;
//
//
//import com.sun.xml.internal.rngom.digested.DValuePattern;
//import sun.plugin.dom.core.Node;
//
//import static java.awt.Color.BLACK;
//import static java.awt.Color.RED;
//
//public class RedBlackTree {
//    public class Node {
//        public  Node(){};
//        public Node left;
//        public Node right;
//        public int value;
//    }
//
//    private Node moveRedLeft(Node h) {
//        flipColors(h);
//        if (isRed(h.right.left)){
//            h.right = rotateRight(h.right);
//            h = rorateLeft(h);
//        }
//        return h;
//    }
//
//    public void deleMin() {
//        if (!isRed(root.left) && !isRed(root.right)) {
//            root.color = RED;
//            root = deleteMin(root);
//            if(!isEmpty()) root.color = BLACK;
//        }
//    }
//
//    private Node deleteMin(Node h) {
//        if (h.left == null)
//            return null;
//        if(!isRed(h.left) && !isRed(h.left.right))
//            h = moveRedLeft(h);
//        h.left = deleteMin(h.left);
//        return balance(h);
//    }
//
//    private Node moveRedRight(Node h) {
//
//    }
//}
