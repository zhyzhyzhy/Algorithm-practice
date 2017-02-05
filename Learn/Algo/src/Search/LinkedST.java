package Search;

/**
 * Created by zhy on 1/29/17.
 */
public class LinkedST {
    public static void main(String[] args) {
    }
}

class LinkedSearchST<Key,Value> {
    private Node head;
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key, Value value) {
        Node p = head;
        while(p != null) {
            if(p.key.equals(key)) {
                p.value = value;
                return;
            }
            p = p.next;
        }
        p = new Node(key, value);
        p.next = head;
        head = p;
    }


    public Value get(Key key) {
        Node search = head;
        while (search != null) {
            if(key.equals(search.key))
                return search.value;
            search = search.next;
        }
        return null;
    }
}

class ArraySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    int size;

    public ArraySearchST(int n) {
        keys = (Key[])new Comparable[n];
        values = (Value[])new Object[n];
    }

    public int rank(Key key) {
        int lo = 0;
        int hi = size - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(keys[mid].compareTo(key) == 0) {
                return mid;
            }
            else if(keys[mid].compareTo(key) > 0) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if(keys[i] != null && keys[i].equals(key)) {
            values[i] = value;
            return;
        }
        for(int j = size ; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public Value get(Key key) {
        int i = rank(key);
        if(keys[i].equals(key))
            return values[i];
        else
            return null;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < size; i++) {
            builder.append(keys[i]+" : "+values[i]+"\n");
        }
        return builder.toString();
    }
}
