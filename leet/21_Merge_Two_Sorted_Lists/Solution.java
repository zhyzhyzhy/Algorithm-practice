
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        while (h1 != null && h2 != null) {
            while (h1.next != null && h1.next.val < h2.val) {
                h1 = h1.next;
            }
            if (h1.val <= h2.val) {
                ListNode p = h1.next;
                h1.next = h2;
                h1 = p;
            }
            if (h1 != null) {
                while (h2.next != null && h2.next.val < h1.val) {
                    h2 = h2.next;
                }
                if (h2.val <= h1.val) {
                    ListNode p = h2.next;
                    h2.next = h1;
                    h2 = p;
                }
            }
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        return l1.val > l2.val ? l2 : l1;
    }
}