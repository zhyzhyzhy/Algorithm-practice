public class Solution {
    public static void main(String[] args) {
        ListNode demo1 = new ListNode(1);
        ListNode demo2 = new ListNode(2);
        ListNode demo3 = new ListNode(3);
        ListNode demo4 = new ListNode(4);
        ListNode demo5 = new ListNode(5);
        demo1.next = demo2;
        demo2.next = demo3;
        demo3.next = demo4;
        demo4.next = demo5;
        ListNode test = oddEvenList(demo1);
        while(test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }
//    public static ListNode oddEvenList(ListNode head) {
//        if(head == null || head.next == null)
//            return head;
//        ListNode even = head;
//        ListNode evenHead = even;
//        ListNode odd = head.next;
//        ListNode oddHead = odd;
//        ListNode p = head.next.next;
//        for(int i = 1; p != null; p = p.next, i++) {
//            if(i%2 == 0) {
//                odd.next = p;
//                odd = odd.next;
//            }
//            else {
//                even.next = p;
//                even = even.next;
//            }
//        }
//        even.next = oddHead;
//        odd.next = null;
//        return evenHead;
//    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode odd = head;
        while(even != null && even.next != null) {
            odd.next = even.next;
            even.next = odd.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

