package List.src.main.java;

import java.util.NoSuchElementException;

public class MyCircularLinkedList<E> {
    private Node last; //리스트의 마지막 노드(항목)을 가리킨다.
    private int size;
    public MyCircularLinkedList(){
        last = null;
        size = 0;
    }

    // last가 가리키는 노드의 다음에 새노드 삽입
    public void insert(E newItem) {
        // 새 노드 생성
        Node newNode = new Node(newItem, null);
        // 리스트가 empty일 때
        if(last == null){
            newNode.setNext(newNode);
            last = newNode;
        }
        else {
            // new node의 다음 노드가 last가 가리키는 노드의 다음 노드가 되도록
            newNode.setNext(last.getNext());
            // last가 가리키는 노드의 다음 노드가 new node가 되도록
            last.setNext(newNode);
        }
        size++;
    }

    // 삭제 연산
    public Node delete() {
        if(isEmpty()) throw new NoSuchElementException();

        Node x = last.getNext();
        if(x == last) last = null;
        else {
            last.setNext(x.getNext());
            x.setNext(null);
        }
        size--;
        return x;
    }

    private boolean isEmpty(){
        if (size == 0)
            return true;
        return false;
    }
}