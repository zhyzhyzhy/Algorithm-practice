/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/11/19 - 11:44:47
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
    public void flatten(TreeNode root) {
        getHead(root);
    }
    public TreeNode getHead(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode node0 = null;
        TreeNode node1 = null;
        if (node.left != null) {
            node0 = getHead(node.left);
        }
        if (node.right != null) {
            node1 = getHead(node.right);
        }
        if (node0 != null) {
          TreeNode node2 = node0;
           while (node2.right != null) {
               node2 = node2.right;
           }
           node2.right = node.right;
           node0.left = null;
           node.right = node0;
        }
        if (node1 != null) {
            node1.left = null;
        }
        node.left = null;
        return node;
    }
}*/
