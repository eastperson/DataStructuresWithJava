package List.src.main.heap;

public class EntryForHeap <Key extends Comparable<Key>,Value> {
    private Key key;
    private Value val;
    public EntryForHeap(Key newKey, Value newValue) {
        key = newKey;
        val = newValue;
    }

    public Key getKey() {return key;}
    public Value getValue() {return val;}
    public void setKey(Key newKey) {key = newKey;}
    public void setValue(Value newValue) {val = newValue;}


}
