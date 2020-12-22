package List.src.main.java;

import java.util.NoSuchElementException;

// 이중 연결 리스트
// 이중 연결 리스트는 previous 노드와 next를 따로 가지고 있다.
public class MyDoublyLinkedList<E>{

    protected DNode head, tail;
    protected int size;
    public MyDoublyLinkedList(){ //

        head = new DNode(null,null,null); // 하나의 노드에는 3가지의 객체를 가지고 있다
        tail = new DNode(null,head,null); // tail의 이전 노드를 head로 만든다.
        head.setNext(tail); // head의 다음 노드를 tail로 만든다.
        size = 0;
    }

    // p가 가리키는 노드 앞에 삽입
    public void insertBefore(DNode p, E newItem) {
        DNode t = p.getPrevious(); // 노드의 이전 노드를 기억한다.
        DNode newNode = new DNode(newItem,t,p); // 새로운 객체(아이템)으로 사이에 껴 넣는다.
        p.setPrevious(newNode); // 새로운 node를 p의 prev로 저장
        t.setNext(newNode); // 새로운 node를 t의 next로 저장
        size++; // 사이즈 추가
    }

    // p가 가리키는 노드 뒤에 삽입
    public void insertAfter(DNode p, E newItem) {
        DNode t = p.getNext();
        DNode newNode = new DNode(newItem,p,t);
        t.setPrevious(newNode);
        p.setNext(newNode);
        size++;
    }

    // 삭제 연산
    public void delete(DNode x) {
        if(x == null) throw  new NoSuchElementException();
        DNode f = x.getPrevious();
        DNode r = x.getNext();
        f.setNext(r);
        r.setPrevious(f);
        size--;

    }
}

class DNode <E> {
    private E item;
    private DNode previous;
    private DNode next;
    public DNode(E newItem, DNode p, DNode q) { // 노드 생성자
        item = newItem;
        previous = p;
        next = q;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public void setPrevious(DNode previous) {
        this.previous = previous;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public DNode getPrevious() {
        return previous;
    }

    public DNode getNext() {
        return next;
    }
}
