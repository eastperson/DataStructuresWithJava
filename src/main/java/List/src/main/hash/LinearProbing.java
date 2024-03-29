package List.src.main.hash;

public class LinearProbing<K,V> {
    private int M = 13; // 테이블 크기
    private K[] a = (K[]) new Object[M]; // 해시테이블
    private V[] d = (V[]) new Object[M]; // key 관련 데이터 저장
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; // 나눗셈함수
    }

    private void put(K key, V data) { // 삽입 연산
        int initialpos = hash(key); // 초기 위치
        int i = initialpos, j =1;
        do {
            if(a[i] == null) { // 삽입 위치 발견
                a[i] = key; // key를 해시테이블에 저장
                d[i] = data; // key관련 데이터를 동일한 인덱스 하에 저장
                return;
            }
            if(a[i].equals(key)) { // 이미 key 존재
                d[i] = data; // 데이터만 갱신
                return;
            }
            i = (initialpos + j++) % M; // i = 다음위치
        } while(i != initialpos); // 현재 i가 초기위치와 같게되면 루프 종료
    }
    public V get(K key) { // 탐색 연산
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        while(a[i] != null){
            if(a[i].equals(key)) return d[i];
            i = (initialpos + j++) % M; // i = 다음위치
        }
        return null; // 탐색 실패패
   }
}
