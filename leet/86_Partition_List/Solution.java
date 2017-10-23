/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/22 - 11:58:16
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode p = small;
        ListNode big = new ListNode(0);
        ListNode q = big;
        while (head != null) {
            if (head.val >= x) {
                q.next = head;
                q = q.next;
            }
            else {
                p.next = head;
                p = p.next;
            }
            head = head.next;
        }
        p.next = big.next;
        q.next = null;
        return small.next;
    }
}
