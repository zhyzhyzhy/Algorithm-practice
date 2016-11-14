import java.util.*;
public class add_two_numbers_2 {
    public static void main(String[] args) {
        ListNode demo = new ListNode(8);
        ListNode demo1 = new ListNode(2);
        demo.next = new ListNode(9);
        demo.next.next = new ListNode(9);
        ListNode dd = addTwoNumbers(demo, demo1);
        while(dd != null) {
            System.out.print(dd.val + "->");
            dd = dd.next;
        }

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        situation 0 : l1 != null && l2 != null
//        situation 1 : l1 == null && l2 != null
//        situation 2 : l1 != null && l2 == null
//        situation 3 : l1 == null && l2 == null
        ListNode head = new ListNode(0);
        ListNode p = head;
        int situation = 0;
        if(l1 != null && l2 != null)
            situation = 0;
        if(l1 == null && l2 != null)
            situation = 1;
        if(l1 != null && l2 == null)
            situation = 2;
        if(l1 == null && l2 == null)
            situation = 3;

        while(situation != 3) {
            if(situation == 1) {
                if(p.val + l2.val < 10)
                    p.val += l2.val;
                else {
                    p.val = 0;
                    p.next = new ListNode(1);
                }
                if (l2.next == null)
                    break;
                if (p.next == null) {
                    p.next = new ListNode(0);
                }
                p = p.next;
                l2 = l2.next;
                continue;
            }
            if (situation == 2) {
                if(p.val + l1.val < 10)
                    p.val += l1.val;
                else{
                    p.val = 0;
                    p.next = new ListNode(1);
                }
                if (l1.next == null)
                    break;
                if (p.next == null) {
                    p.next = new ListNode(0);
                }
                p = p.next;
                l1 = l1.next;
                continue;
            }

            if(situation == 0) {
                if(l1.val + l2.val + p.val < 10) {
                    p.val += l1.val + l2.val;
                    if(l1.next !=  null || l2.next != null)
                        p.next = new ListNode(0);
                    else;
                }
                else  {
                    p.next = new ListNode(1);
                    p.val = (l1.val + l2.val + p.val)%10;
                }
                l1 = l1.next;
                l2 = l2.next;
                p = p.next;
                if(l1 == null && l2 == null)
                    situation = 3;
                if(l1 != null && l2 == null)
                    situation = 2;
                if(l1 == null && l2 != null)
                    situation = 1;
            }
        }
        return head;
    }

}
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
