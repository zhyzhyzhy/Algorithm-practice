//讨论中的一个递归写法很有意思
/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/04/20 - 10:14:39
*/
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class Solution {

	public static void main(String[] args) {
		
	}
    public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode q = head;
		while( q != null) {
			if (q.next != null) {
				if (q.val == q.next.val) {
					q.next = q.next.next;
				}
				else {
					q = q.next;
				}
			}
			else {
				break;
			}
		}
		return head;
	}
	

}

