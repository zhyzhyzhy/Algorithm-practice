class Node {
    int i;
    Node next;
    Node(int i) {
        this.i = i;
    }
}

public class Solution {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        } 
        Node p = head;
        Node q = head.next;
        Node m = q.next;
        p.next = null;
        while (m != null) {
            // System.out.println(m.i);
            q.next = p;
            p = q;
            q = m;
            m = m.next;
        }
        q.next = p;
        return q;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = new Node(6);
        head = solution.reverse(head);
        while (head != null) {
            System.out.println(head.i);
            head = head.next;
        }
    }
}