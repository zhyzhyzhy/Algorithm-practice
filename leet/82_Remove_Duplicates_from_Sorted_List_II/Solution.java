/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/22 - 12:16:05
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = new ListNode(0);
        ListNode p = start;
        while (head != null && head.next != null) {
            ListNode temp = head.next;
            while (temp != null && head.val == temp.val) {
                temp = temp.next;
            }
            if (head.next == temp) {
                p.next = head;
                p = p.next;
            }
            head = temp;
        }
        if (head != null ) {
            p.next = head;
            p = p.next;
        }
        p.next = null;
        return start.next;
    }
}
