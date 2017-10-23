/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/22 - 13:59:33
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return rToBST(head);    
    }
    public TreeNode rToBST(ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return new TreeNode(node.val);
        }
        if (node.next.next == null) {
            TreeNode node1 = new TreeNode(node.val);
            TreeNode node2 = new TreeNode(node.next.val);
            node1.right = node2;
            return node1;
        }
        ListNode p = node;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        count = count / 2;
        ListNode beforep = node;
        p = node;
        while (count > 0) {
            beforep = p;
            p = p.next;
            count--;
        }
        beforep.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = rToBST(node);
        root.right = rToBST(p.next);
        return root;
    }
}
