package List.src.main.hash;

public class DoubleHashing<K,V> {
    private int N = 0,M = 13; // 테이블 크기
    private K[] a = (K[]) new Object[M]; // 해시테이블
    private V[] dt = (V[]) new Object[M]; // key 관련 데이터 저장
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; // 나눗셈함수
    }

    private void put(K key, V data) { // 삽입 연산
        int initialpos = hash(key); // 초기 위치
        int i = initialpos, j =1;
        int d = (7-(int)key % 7);
        do {
            if(a[i] == null) { // 삽입 위치 발견
                a[i] = key; // key를 해시테이블에 저장
                dt[i] = data; N++; // key관련 데이터를 동일한 인덱스 하에 저장, 항목 수 1증가
                return;
            }
            if(a[i].equals(key)) { // 이미 key 존재
                dt[i] = data; // 데이터만 갱신
            }
            i = (initialpos + j*d) % M; // i = 다음위치
            j++;
        } while(N < M);
    }
    public V get(K key) { // 탐색 연산
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        int d =(7-(int)key %7);
        while(a[i] != null){
            if(a[i].equals(key)) return dt[i];
            i = (initialpos + j*d) % M; // i = 다음위치
            j++;
        }
        return null; // 탐색 실패
    }
}
