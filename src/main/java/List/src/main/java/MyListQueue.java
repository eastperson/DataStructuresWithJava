package List.src.main.java;

import java.util.NoSuchElementException;

public class MyListQueue<E> {
    private Node<E> front, rear;
    private int size;
    public MyListQueue(){
        front = rear = null;
        size = 0;
    }
    public int size() {return size;} // 큐의 항목의 수를 리턴
    public boolean isEmpty(){return size() == 0;} // 큐가 empty이면 true 리턴

    public void add(E newItem) {
        Node newNode = new Node(newItem,null); // 새 노드 생성
        if(isEmpty()) front = newNode; // 큐가 empty이었으면 front도 newNode를 가리키게 한다.
        else rear.setNext(newNode); // 그렇지 않으면 rear의 next를 newNode를 가리키게 한다.
        rear = newNode; // 큐 항목 수 1 증가
        size++;
    }

    public E remove() {
        if(isEmpty()) throw new NoSuchElementException();
        E frontItem = front.getItem();
        front = front.getNext();
        if(isEmpty()) rear = null;
        size--;
        return frontItem;
    }
}
