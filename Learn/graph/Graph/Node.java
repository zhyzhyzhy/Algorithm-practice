package Graph;

/**
 * Created by zhy on 2/4/17.
 */
public class Node {
    int v;
    int weight;
    Node next;

    public Node() {

    }
    public Node(int v, int weight, Node next) {
        this.v = v;
        this.weight = weight;
        this.next = next;
    }
    public Node(int v, Node next) {
        this.weight = 0;
        this.v = v;
        this.next = next;
    }

}
