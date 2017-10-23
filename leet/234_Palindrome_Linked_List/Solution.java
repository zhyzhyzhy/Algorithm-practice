/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            if (head.val == head.next.val) {
                return true;
            }
            else {
                return false;
            }   
        }
        int count = 0;
        int mid = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count++;
        }
        if (count % 2 ==0) {
            mid = count / 2 + 1;
        }
        else {
            mid = count / 2 + 2;
        }
        ListNode rightStart = head;
        for (int i = 1; i < mid; i++) {
            rightStart = rightStart.next;
        }
        //System.out.println(rightStart.val + " " + rightStart.next.val);
        if (rightStart.next != null) {
            if (rightStart.next.next == null) {
                ListNode temp = rightStart.next;
                rightStart.next.next = rightStart;
                rightStart.next = null;
                rightStart = temp;
            }
            else {
                ListNode q = rightStart.next;
                ListNode r = q.next;
                while (r != null) {
                    q.next = rightStart;
                    rightStart = q;
                    q = r;
                    r = r.next;
                }
                q.next = rightStart;
                rightStart = q;
            }
        }
        mid = count - mid + 1;
        for (int i = 0; i < mid; i++) {
            //System.out.println(rightStart.val);
            if (rightStart.val != head.val) {
                return false;
            }
            rightStart = rightStart.next;
            head = head.next;
        }
        return true;      
    }
}
