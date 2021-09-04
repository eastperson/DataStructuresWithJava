package List.src.main.tree;

import org.w3c.dom.Node;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private NodeForRedBlackTree root;
    private class NodeForRedBlackTree {
        Key id;
        Value name;
        NodeForRedBlackTree left, right;
        boolean color;
        public NodeForRedBlackTree(Key k, Value v, boolean col) {
            id = k;
            name = v;
            color = col;
            left = right = null;
        }
    }

    private boolean isEmpty(){return root == null;}
    private boolean isRed(NodeForRedBlackTree n) {
        if(n == null) return false;
        return (n.color == RED);
    }
}
