import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList <E> {
    private E a[]; // 리스트의 항목들을 저장할 배열
    private int size; // 리스트의 항목 수

    public E peek(int k) { // k번째 항목을 리턴, 단순히 읽기만 한다.
        if(size == 0)
            throw new NoSuchElementException("underflow 발생!"); // overflow인 경우 프로그램 정지
        return a[k];
    }

    public void insertLast(E newItem) { // 가장 뒤에 새 항목 삽입
        if (size == a.length) // 배열에 빈  공간이 없으면
            resize(2*a.length); // 배열 크기 2배로 확장
        a[size++] = newItem; // 새 항목 삽입
    }

    public void insert(E newItem, int k) { // 새 항목을 k-1번째 항목 다음에 삽입
        if(size == a.length) // 배열에 비공간이 없으면
            resize(2*a.length); // 배열 크기 2배로 확장

        for (int i = size - 1; i>= k; i--) // 한 칸씩 뒤로 이동
            a[i+1] = a[i];
        a[k] = newItem;
        size++;

    }

    public E delete(int k) { // k번째 항목 삭제
        if(isEmpty()) throw new NoSuchElementException(); // underflow 경우에 플로우 중지
        E item = a[k];
        for(int i = k; i < size; i++) a[i] = a[i+1]; // 한 칸씩 앞으로 이동
        size--;
        if (size > 0 && size == a.length/4) // 배열에 항목들이 1/4만 차지한다면
            resize(a.length/2);     // 배열을 1/2 크기로 축소
        return item;
    }

    private boolean isEmpty(){
        if (size == 0)
            return true;
        return false;
    }

    private void resize(int newSize){ // 배열의 크기 조절
        Object[] t = new Object[newSize]; // newSize 크기의 새로운 배열 t 생성
        for (int i = 0; i < size; i++)
            t[i] = a[i]; // 배열 s를 배열 t로 복사
        a = (E[]) t; // 배열 t를 배열 s로
    }

    public MyArrayList(){
        a = (E[]) new Object[1]; // 최초에 1개의 원소를 가진 배열 생성
        size = 0; // 항목 수를 0으로 초기화
    }

    public E[] getA() {
        return a;
    }

    public int getSize() {
        return size;
    }

    public void setA(E[] a) {
        this.a = a;
    }

    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return "MyArrayList{" +
                "a=" + Arrays.toString(a) +
                ", size=" + size +
                '}';
    }
}

class  test{
    public static void main(String[]args){

        MyArrayList list = new MyArrayList();
        MyArrayList list2 = new MyArrayList();

        System.out.println("list : " + list);
        System.out.println("list a  : " + list.getA());
        System.out.println("list a  length : " + list.getA().length);
        System.out.println("list size  : " + list.getSize());

        // peek test
        try{
            System.out.println("list peek index 2 : "+list.peek(2));
        } catch (NoSuchElementException ne) {
            System.out.println("===error===");
            System.out.println(ne.getMessage());
        } finally {
            System.out.println("peek test complete");
        }

        // insert last test
        System.out.println("===insert last test===");
        long beforeTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++)
            list.insertLast(new Object());
        long afterTime = System.currentTimeMillis();
        System.out.println("list size : " + list.getSize());
        System.out.println("insert last resource time : " + (afterTime - beforeTime));

        // inset first test
        System.out.println("===insert first test===");
        long befTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++)
            list2.insert(new Object(), 0);
        long aftTime = System.currentTimeMillis();
        System.out.println("list2 size : " + list2.getSize());
        System.out.println("insert first  resource time : " + (aftTime - befTime));

        // delete test
        System.out.println("===delete test===");
        long befDelTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++)
            list2.delete(0);
        long aftDelTime = System.currentTimeMillis();
        System.out.println("list2 size : " + list2.getSize());
        System.out.println("insert first  resource time : " + (aftDelTime - befDelTime));
    }
}
