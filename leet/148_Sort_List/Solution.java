import java.util.Arrays;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Solution {
    public static  ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head;
        int i = 0;
        int[] nums = new int[1000000];
        while(p != null) {
            nums[i++] = p.val;
            p = p.next;
        }
        Arrays.sort(nums,0,i );
        p = head;
        i = 0;
        while(p != null) {
            p.val = nums[i++];
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}