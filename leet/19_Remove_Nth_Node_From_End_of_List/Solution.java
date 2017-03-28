class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        count  = count - n + 1;
        if (count == 1) {
            return head.next;
        }
        else if (count == 2) {
            head.next = head.next.next;
            return head;
        }

        node = head.next;
        ListNode node1 = head;
        while (count > 2) {
            node = node.next;
            node1 = node1.next;
            count--;

        }
        node1.next = node.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        head = solution.removeNthFromEnd(head,2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}