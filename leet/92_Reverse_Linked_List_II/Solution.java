class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
       ListNode p = head;
       for (int i = 1; i < m; i++) {
            p = p.next;
       } 
       for (int i = 0; i < n - m; i++) {
           ListNode q = p;
           for (int j = 0; j < n - m - i; j++) {
               int temp = q.val;
               q.val = q.next.val;
               q.next.val = temp;
               q = q.next;
           }
       }
       return head;
    }
	public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode temp = new ListNode(head.val);
        temp.next = head;
        head = temp;
        //the node before node m
        ListNode start = head;
        for (int i = 1; i < m; i++) {
            start = start.next;
        }
        ListNode p = start.next;
        ListNode q = p.next;
        ListNode r = q.next;
        for (int i = 0; i < n - m - 1; i++) {
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        q.next = p;
        start.next.next = r;
        start.next = q;
        return head.next;
    }
    public static void main(String[] args) {
        
    }
}
