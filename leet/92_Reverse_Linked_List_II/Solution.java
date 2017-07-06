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
    public static void main(String[] args) {
        
    }
}