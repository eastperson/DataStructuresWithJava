package List.src.main.hash;

public class Chaining<K,V> {
    private int M = 13;
    private NodeForHash[] a = new NodeForHash[M]; // 해시테이블
    public static class NodeForHash {
        private Object key;
        private Object data;
        private NodeForHash next;
        public NodeForHash(Object newKey,Object newdata, NodeForHash ref) {
            this.key = newKey;
            this.data = newdata;
            this.next = ref;
        }
    }
    private int hash(K key) {
        return (key.hashCode() & 0x7ffffff) & M;
    }
    public V get(K key) {
        int i = hash(key);
        for(NodeForHash x = a[i]; x != null; x = x.next) {
            if(key.equals(x.key)) return (V) x.data; // 탐색 성공
        }
        return null; // 탐색 실패
    }
    private void put(K key, V data) { // 삽입 연산
        int i = hash(key);
        for(NodeForHash x = a[i]; x != null; x = x.next) {
            if(key.equals(x.key)) { // 이미 key 존재
                x.data = data; // 데이터만 갱신
                return;
            }
        }
        a[i] = new NodeForHash(key,data,a[i]); // 연결리스트의 첫 노드로 삽입
    }
}
