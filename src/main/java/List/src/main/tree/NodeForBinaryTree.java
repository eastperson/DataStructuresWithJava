package List.src.main.tree;

import List.src.main.java.NodeForTree;

public class NodeForBinaryTree<Key extends Comparable<Key>, Value> {

    private Key id;
    private Value name;
    private NodeForBinaryTree left;
    private NodeForBinaryTree right;
    public NodeForBinaryTree(Key newId, Value newName) {
        this.id = newId;
        this.name = newName;
        left = right = null;
    }
    public Key getKey() {return id;}
    public Value getValue() {return name;}
    public NodeForBinaryTree getLeft() {return left;}
    public NodeForBinaryTree getRight() {return right;}
    public void setKey(Key newId) {id = newId;}
    public void setValue(Value newName) {name = newName;}
    public void setLeft(NodeForBinaryTree lt){left = lt;}
    public void setRight(NodeForBinaryTree rt) {right = rt;}

}