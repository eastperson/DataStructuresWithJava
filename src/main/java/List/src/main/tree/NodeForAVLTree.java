package List.src.main.tree;

import com.sun.jdi.Value;


public class NodeForAVLTree<Key extends Comparable<Key>> {
    private Key id;
    private Value name;
    private int height;
    private NodeForAVLTree left, right;
    public NodeForAVLTree(Key newId, Value newName, int newHt){
        id = newId;
        name = newName;
        height = newHt;
        left = right = null;
    }


}
