class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = swapPairs(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
	public static ListNode swapPairs(ListNode head) {
        ListNode p = head;
        if(p == null)
            return head;
        if(p.next != null ) {
            ListNode q = p.next;
            p.next = q.next;
            q.next = p;
            head = q;
        }
        ListNode preNode = p;
        p = p.next;
        while(p != null && p.next != null) {
            ListNode q = p.next;
            p.next = q.next;
            q.next = p;
            preNode.next = q;
            preNode = p;
            p = p.next;
        }
        return head;
	}
}