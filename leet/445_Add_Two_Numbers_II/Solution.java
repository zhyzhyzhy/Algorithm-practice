//写的太蠢了。。。。
import java.util.Arrays;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }
        int length1 = 0;
        int length2 = 0;
        for (ListNode i = l1; i != null; i = i.next) {
            length1++;
        } 
        for (ListNode i = l2; i != null; i = i.next) {
            length2++;
        } 
        int[] cas = new int[length1 > length2 ? length1: length2];
        int[] save = new int[length1 > length2 ? length1: length2];
        ListNode p = l1;
        ListNode q = l2;
        int i = 0;
        if (length1 > length2) {
           for (i = 0; i < length1 - length2; i++) {
               save[i] = p.val;
               p = p.next;
           } 
        }
        else {
           for (i = 0; i < length2 - length1; i++) {
               save[i] = q.val;
               q = q.next;
           } 
        }
        while(i < (length1 > length2? length1 : length2)) {
            int num = p.val + q.val;
            if (num > 9) {
                cas[i] = 1;
                num = num % 10;
            }
            save[i] = num;
            p = p.next;
            q = q.next;
            i++;
        }
        int carry = 0;
        for (int j = save.length - 2; j >= 0; j--) {
            int num = save[j] + cas[j + 1] + carry;
            if (num > 9) {
                carry = 1;
                num = num % 10;
            }
            else {
                carry = 0;
            }
            save[j] = num;
        }
        // System.out.println(Arrays.toString(save));
        // System.out.println(Arrays.toString(cas));
        ListNode head = new ListNode(cas[0] + carry);
        ListNode hp = head;
        for (int k = 0; k < save.length; k++) {
            hp.next = new ListNode(save[k]);
            hp = hp.next;
        }
        if (carry == 1 || cas[0] == 1) {
            return head;
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        Solution solution = new Solution();
        solution.addTwoNumbers(head1, head2);
    }
}