/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/19 - 18:36:25
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode first = getFirstNode(root);
        return isValidSubBST(root, first);
    }
    public TreeNode getFirstNode(TreeNode node) {
        if(node.left == null) {
            return node;
        }
        else {
            return getFirstNode(node.left);
        }
    }
    public boolean isValidSubBST(TreeNode node, TreeNode min) {
        if (node == null) {
            return true;
        }
        if (!isValidSubBST(node.left, min)) {
            return false;
        }
        if (node.val <= min.val && min != node) {
            return false;
        }
        else {
            min.val = node.val;
            return isValidSubBST(node.right, min);
        }
    }
}
