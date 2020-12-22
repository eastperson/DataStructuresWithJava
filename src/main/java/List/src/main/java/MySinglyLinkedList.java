package List.src.main.java;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<E> {

    protected Node head;
    private int size;
    public MySinglyLinkedList(){
        head = null;
        size = 0;
    }

    // 탐색은 순차적으로 진행된다.
    public int search(E target) {
        // head부터 시작
        Node p = head;
        // target과 일치하는 노드(객체)가 나올 때 까지 순차적으로 탐색 (O(N))
        for(int k = 0; k < size; k++){
            if(target == p.getItem()) return k;
            p = p.getNext();
        }

        return -1; // 탐색을 실패했을 경우 -1 리턴
    }

    // 연결 리스트 맨 앞쪽에 노드를 삽입
    // 첫 번째 노드에만 방문 하므로 O(1)
    public void insertFront(E newItem){
        head = new Node(newItem, head); // 기존의 head를 next에 담고 head는 새로운 node를 가르킨다.
        size++;
    }

    // 노드 p 바로 다음에 새 노드 삽입
    // 특정 노드 p의 참조값이 주어지지 않은 경우 search()를 수행하기 때문에 O(n)
    public void insertAfter(E newItem, Node p) {
        p.setNext(new Node(newItem,p.getNext())); // 기존의 p의 next 노드를 new item의 next 노드에 넣어준다.
        size++;
    }

    // delete연산은 실질적인 삭제 연산이 들어가는 것이 아니라 참조변경을 한다.(gc가 알아서 처리)
    // 리스트의 첫 노드 삭제
    // 첫 번째 노드에만 방문 하므로 O(1)
    public void deleteFront(){
        if(isEmpty()) throw new NoSuchElementException();
        head = head.getNext(); // head의 다음 노드를 head로 저장한다.
        size--;
    }

    // 해당 노드의 다음 노드를 삭제한다.
    // 특정 노드 p의 참조값이 주어지지 않은 경우 search()를 수행하기 때문에 O(n)
    public void deleteAfter(Node p){
        if(p == null) throw new NoSuchElementException(); // p가 존재하지 않으면 예외 발생
        Node t = p.getNext(); // p의 다음 노드를 trget으로 설정한다.
        p.setNext(t.getNext()); // p의 다음 노드를 t의 다음노드(p의 다다음 노드)로 설정한다.
        t.setNext(null); // t와 다음 노드의 연결을 끊어준다.(t는 참조 카운트(reference count)가 0이 되면서 삭제
       size--;
    }

    private boolean isEmpty(){
        if (size == 0)
            return true;
        return false;
    }

}

class Node<E> {
    private E item;
    private Node<E> next;

    public Node(E newItem, Node<E> node) {
        item = newItem;
        next = node;
    }
    // get과 set 메서드
    public E getItem(){return item;}
    public Node<E> getNext(){return next;}
    public void setItem(E newItem){item = newItem;}
    public void setNext(Node<E> newNext){next=newNext;}
}
