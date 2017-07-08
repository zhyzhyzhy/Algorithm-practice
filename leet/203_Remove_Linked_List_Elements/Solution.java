class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }        
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            if (q.val == val) {
                p.next = q.next;
                q = q.next;
            }
            else {
                p = p.next;
                q = q.next;
            }
        }
        if (head.val == val) {
            return head.next;
        }
        return head;
        
    }
}