/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/11/06 - 13:40:51
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        ListNode p = headA;
        while (p.next != null) {
            p = p.next;
        }
        p.next = headA;
        ListNode fast = headB;
        ListNode slow = headB;
        boolean hasCircle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCircle = true;
                break;
            }
        }
        if (hasCircle) {
            slow = headB;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            p.next = null;
            return fast;
        }
        else {
            p.next = null;
            return null;
        }

    }
}
