class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if (search(node, p) && search(node, q)) {
                if (search(node.left, p) && search(node.left, q)) {
                    node = node.left;
                }
                else if (search(node.right, p) && search(node.right, q)) {
                    node = node.right;
                } else {
                    return node;
                }
            }
        } 
        return root;
    }    
    public boolean search(TreeNode node, TreeNode p) {
        if (node == null) {
            return false;
        }
        if (node.val == p.val) {
            return true;
        }
        if (node.val > p.val) {
            return search(node.left, p);
        } 
        if (node.val < p.val) {
            return search(node.right, p);
        }
        return false;
    }
}