public class Solution {
	public static  ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode newHead = new ListNode(Integer.MIN_VALUE);
		newHead.next = head;
		ListNode n = newHead;
		ListNode p = n.next;
		while( p != null) {
			if( n.val > p.val) {
				ListNode q = newHead;
				ListNode m = q;
				while(q.val <= p.val) {
					m = q;
					q = q.next;
				}
				m.next = p;
				n.next = p.next;
				p.next = q;
				p = n.next;
			}
			else {
				n = p;
				p = p.next;
			}
		}
		return newHead.next;
	}
	public static void main(String[] args) {
		ListNode demo1 = new ListNode(2);
		ListNode demo2 = new ListNode(0);
		ListNode demo3 = new ListNode(0);
		ListNode demo4 = new ListNode(5);
		ListNode demo5 = new ListNode(4);

		demo1.next = demo2;
		demo2.next = demo3;
		demo3.next = demo4;
		demo4.next = demo5;

		ListNode result = insertionSortList(demo1);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
