package List.src.main.java;

import java.util.EmptyStackException;

public class MyListStack<E> {
    private Node<E> top; // 스택 top 항목을 가진 Node를 가리키기 위해
    private int size; // 스택의 항목 수
    public MyListStack() {
        top = null;
        size = 0;
    }
    public int size() {return size;} // 스택의 항목수를 리턴
    public boolean isEmpty() {return size == 0;} // 스택이 empty이면 true 리턴

    public E peek() { // 스택 top 항목만을 리턴
        if(isEmpty()) throw new EmptyStackException();
        return top.getItem();
    }

    public void push(E newItem) { // 스택 push 연산
        Node newNode = new Node(newItem,top); // 리스트 앞부분에 삽입, 현재 top 노드를 참조
        top = newNode; // top이 새 노드를 가리킴
        size++; // 스택 항목 수 1 증가
    }

    public E pop() { // 스택 pop 연산
        if(isEmpty()) throw new EmptyStackException();
        E topItem = top.getItem(); // 스택 top 항목을 top item에 저장
        top = top.getNext(); // top이 top 아래의 항목을 가리킴
        size--;
        return topItem;
    }
}
