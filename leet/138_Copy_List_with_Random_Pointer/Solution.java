/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/11/06 - 14:05:13
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode p = head;
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        RandomListNode newList = new RandomListNode(1);
        RandomListNode q = newList;
        while (p != null) {
            q.next = p.next;
            p.next = q.next.next;
            p = p.next;
            q = q.next;
        }
        return newList.next;
    }
}
