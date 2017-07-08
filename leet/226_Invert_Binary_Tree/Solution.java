class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right != null) {
            node.left = node.right;
            node.right = null;
        }
        else if (node.left != null && node.right == null) {
            node.right = node.left;
            node.left = null;
        } else {
            TreeNode node1 = node.left;
            node.left = node.right;
            node.right = node1;
        }
        invert(node.left);
        invert(node.right);
    }
    public static void main(String[] args) {
        
    }
}