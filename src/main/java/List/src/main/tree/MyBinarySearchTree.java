package List.src.main.tree;


import List.src.main.java.NodeForTree;
import org.w3c.dom.Node;

public class MyBinarySearchTree<Key extends Comparable<Key>, Value> {
    public NodeForBinaryTree root;
    public NodeForBinaryTree getRoot() {return root;}
    public MyBinarySearchTree(Key newId, Value newName) {
        root = new NodeForBinaryTree(newId,newName);
    }

    public Value get(Key k) {return get(root,k);}
    public Value get(NodeForBinaryTree n, Key k) {
        if(n==null) return null;
        int t = n.getKey().compareTo(k); // key와 key를 비교
        if(t > 0) return get(n.getLeft(),k); // k가 n의 id보다 작으면 왼쪽 서브트리 탐색
        else if (t < 0) return get(n.getRight(),k); // k가 n의 id보다 크면 오른쪽 서브트리 탐색
        else return (Value) n.getValue();
    }

    public void put(Key k, Value v) {root = put(root,k,v);}
    public NodeForBinaryTree put(NodeForBinaryTree n, Key k, Value v) {
        if(n==null) return new NodeForBinaryTree(k,v);
        int t = n.getKey().compareTo(k);
        if(t>0) n.setLeft(put(n.getLeft(),k,v)); // 왼쪽 서브트리에 삽입
        else if(t<0) n.setRight(put(n.getRight(),k,v)); // 오른쪽 서브트리에 삽입
        else n.setValue(v); // 노드 n의 name을 v로 갱신
        return n;
    }

    public Key min() {
        if(root == null) return null;
        return (Key) min(root).getKey();
    }
    private NodeForBinaryTree min(NodeForBinaryTree n) {
        if(n.getLeft() == null) return n;
        return min(n.getLeft());
    }

    public void deleteMin(){
        if(root == null) System.out.println("empty 트리");
        root = deleteMin(root);
    }
    public NodeForBinaryTree deleteMin(NodeForBinaryTree n) {
        if(n.getLeft() == null) n.getRight();
        n.setLeft(deleteMin(n.getLeft()));
        return n;
    }

    public void delete(Key k){
        root = delete(root,k);
    }
    public NodeForBinaryTree delete(NodeForBinaryTree n,Key k) {
        if(n==null) return null;
        int t = n.getKey().compareTo(k);
        if(t>0) n.setLeft(delete(n.getLeft(),k));
        else if (t<0) n.setRight(delete(n.getRight(),k));
        else {
            // 자식 노드가 없거나 하나만 있을 때,
            if(n.getRight() == null) return n.getLeft();
            if(n.getLeft() == null) return n.getRight();

            // 자식 노드가 둘이 있을 때
           NodeForBinaryTree target = n;

            // 삭제할 노드 자리로 옮겨올 노드 찾아서 n이 가리키게 함
            // 오른쪽 노드중에서 가장 작은 값을 가운데로 바꿈
            n = min(target.getRight());
            // 가져온 기존 값을 제거
            n.setRight(deleteMin(target.getRight()));
            //
            n.setLeft(target.getLeft());
        }
        return n;
    }

}
