package List.src.main.java;

public class NodeForTree<Key extends Comparable<Key>> {

    private Key item;
    private NodeForTree<Key> left;
    private NodeForTree<Key> right;
    public NodeForTree(Key newItem, NodeForTree lt, NodeForTree rt) {
        this.item = newItem;
        this.left = lt;
        this.right = rt;
    }
    public Key getKey() {return item;}
    public NodeForTree<Key> getLeft() {return left;}
    public NodeForTree<Key> getRight() {return right;}
    public void setKey(Key newItem) {item = newItem;}
    public void setLeft(NodeForTree<Key> lt){left = lt;}
    public void setRight(NodeForTree<Key> rt) {right = rt;}

}
