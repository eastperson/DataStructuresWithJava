//package List.src.main.heap;
//
//public class Huffman {
//    private EntryForHuffman[] a; // a[0]은 사용 안함
//    private int N; // 힙의 크기
//    public Huffman(EntryForHuffman[] harray, int initialSize) {
//        a = harray;
//        N = initialSize;
//    }
//    private boolean greater(int i, int j) {
//        return a[i].getKey() > a[j].getKey();
//    }
//    public EntryForHuffman createTree(){
//        while(size() > 1) { // 힙에 1개의 노드만 남을 때까지
//            EntryForHuffman e1 = deleteMin(); // 힙에서 최소 빈도 수 가진 노드 제거하여 e1이 참조
//            EntryForHuffman e2 = deleteMin(); // 힙에서 최소 빈도 수 가진 노드 제거하여 e2가 참조
//            EntryForHuffman temp = new EntryForHuffman(e1.getKey()+e2.getKey(), // e1과 e2 빈도수를 합산
//                e1.getValue() + e2.getValue(), // string 이어 붙이기
//                    e1,e2, ""); // e1, e2가 각각 새노드의 왼쪽 오른쪽 자식
//            insert(temp); // 새 노드를 힙에 삽입
//        }
//        return deleteMin();
//    }
//}
