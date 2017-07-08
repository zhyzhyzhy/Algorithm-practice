
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode r = head.next;
        while ( q != null) {
            r = r.next;
            q.next = p;
            p = q;
            q = r;
        }
        head.next = null; 
        return p;
    }
    public static void main(String[] args) {
        
    }
}