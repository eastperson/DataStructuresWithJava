package List.src.main.heap;

public class BHeap<Key extends Comparable<Key>,Value> {
    private EntryForHeap[] a; // a[0]은 사용 안함
    private int N; // 힙의 크기, 힙에 있는 항목수
    public BHeap(EntryForHeap[] harray, int initialSize) {
        a = harray;
        N = initialSize;
    }

    // 힙의 크기 리턴
    public int size() {return N;}

    // 키 비교
    private boolean greater(int i, int j) {
        return a[i].getKey().compareTo(a[j].getKey())>0;
    }

    // a[i]와 a[j]를 교환
    private void swap(int i, int j) {
        EntryForHeap temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 초기 힙 만들기
    public void createHeap() {
        for(int i = N/2; i> 0; i++) {
            downheap(i);
        }
    }

    // i는 현재 노드의 인덱스
    private void downheap(int i){
        // i의 왼쪽 자식노드가 힙에 있으면
        while(2*i <= N) {
            // k는 왼쪽 자식노드의 인덱스
            int k = 2*i;

            // k가 승자의 인덱스가 됨
            if(k< N && greater(k,k+1)) k++;

            // 현재 노드가 자식 승자와 같거나 작으면 루프를 중단
            if(!greater(i,k)) break;

            // 현재 노드가 자식 승자보다 크면 현재 노드와 자식 승자와 교환
            swap(i,k);

            // 자식 승자가 현재 노드가 되이ㅓ 다시 반복하기 위해
            i = k;
        }
    }

    // 새로운 항목 삽입
    public void insert(Key newKey, Value newValue) {
        // Entry 생성
        EntryForHeap temp = new EntryForHeap(newKey,newValue);
        // 새로운 키(항목)를 배열 마지막 항목 다음에 저장
        a[++N] = temp;
        // 위로 올라가며 힙속성 회복시키기 위해
        upheap(N);
    }

    // j는 현재 노드의 인덱스
    private void upheap(int j){
        // 현재 노드가 루트가 아니고 동시에 부모가 크면
        while(j > 1 && greater(j/2,j)){
            // 부모와 현재 노드 교환
            swap(j/2,j);
            // 부모가 현재 노드가 되어 다시 반복하기 위해
            j = j/2;
        }
    }

    // 최소값 삭제
    public EntryForHeap deleteMin(){
        // a[1]의 최솟값을 min으로 저장하여 리턴
        EntryForHeap min = a[1];
        // 힙의 마지막 항목과 교환하고 힙 크기 1 감소
        swap(1,N--);
        // 마지막 항목을 null로 처리
        a[N+1] = null;
        // 힙속성을 회복시키기 위해
        downheap(1);
        return min;
    }

}
