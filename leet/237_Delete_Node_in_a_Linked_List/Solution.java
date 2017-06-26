/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/05/29 - 18:41:29
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public void deleteNode(ListNode node) {
		ListNode q = node;
		ListNode p = node.next;
		while (p != null) {
			q.val = p.val;
			node = q;
			q = p;
			p = p.next;
		}
		node.next = null;
    }
	public static void main(String[] args) {
		
	}
}

