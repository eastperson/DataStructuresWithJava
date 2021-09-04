package List.src.main.heap;

public class EntryForHuffman {
    private int frequency; // 빈도 수
    private String word; // 이파리 노드의 문자 또는 내부노드의 합성된 문자열
    private EntryForHuffman left; // 왼쪽 자식
    private EntryForHuffman right; // 오른쪽 자식
    private String code; // 허프만 코드
    public EntryForHuffman (int newFreq, String newValue, EntryForHeap left, EntryForHeap right, String s) {
        frequency = newFreq;
        word = newValue;
        left = left;
        right = right;
        code = s;
    }
    public int getKey() {return frequency;}
    public String getValue(){return word;}
    public String getCode(){return code;}
    public EntryForHuffman getLeft() {return left;}
    public EntryForHuffman getRight() {return right;}
    public void setCode(String newCode) {code = newCode;}
}
