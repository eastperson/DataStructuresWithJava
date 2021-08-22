package List.src.main.java;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree<Key extends Comparable<Key>> {
    private NodeForTree root;
    public MyBinaryTree() {root = null;} // 트리 생성자
    public NodeForTree getRoot() {return root;}
    public void setRoot(NodeForTree newRoot){root = newRoot;}
    public boolean isEmpty(){return root == null;}

    public void preorder(NodeForTree n) { // 전위순회
        if(n != null) {
            System.out.print(n.getKey() + " "); // 노드 n 방문
            preorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
            preorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
        }
    }

    public void inorder(NodeForTree n) { // 중위순회
        if(n != null) {
            inorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
            System.out.print(n.getKey() + " "); // 노드 n 방문
            inorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
        }
    }

    public void postorder(NodeForTree n) { // 후위순회
        if(n != null) {
            postorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
            postorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
            System.out.print(n.getKey() + " "); // 노드 n 방문
        }
    }

    public void levelorder(NodeForTree root) { // 레벨 순회
        Queue<NodeForTree> q = new LinkedList<NodeForTree>(); // 큐 자료구조 이용, bfs
        NodeForTree t;
        q.add(root); // 루트 노드 큐에 삽입
        while(!q.isEmpty()){
            t = q.remove(); // 큐에서 가장 앞에 있는 노드 제거
            System.out.print(t.getKey() + " "); // 제거된 노드 출력(방문)
            if(t.getLeft() != null) { // 제거된 왼쪽 자식이 null이 아니면
                q.add(t.getLeft()); // 큐에 왼쪽 자식 삽입
            }
            if(t.getRight() != null) { // 제거된 오른쪽 자식이 null이 아니면
                q.add(t.getRight()); // 큐에 오른쪽 자식 삽입
            }
        }
    }

    public int size(NodeForTree n) { // n을 루트로 하는 (서브)트리에 있는 노드 수
        if(n==null) return 0;
        else return (1 + size(n.getLeft())) + size(n.getRight());
    }

    public int height(NodeForTree n) { // n을 루트로하는 (서브)트리의 높이
        if (n == null) return 0;
        else return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
    }

    public static boolean isEqual(NodeForTree n, NodeForTree m) { // 두 트리의 동일성 검사
        if(n == null || m == null) return n == m; // 둘 다 null이면 true, 아니면 false

        if(n.getKey().compareTo(m.getKey()) != 0) return false; // 둘다 null이 아니면 item 비교

        // item이 같으면 왼쪽/오른쪽 자식으로 재귀호출
        return (isEqual(n.getLeft(),m.getLeft()) && isEqual(m.getRight(),m.getRight()));
    }
}
