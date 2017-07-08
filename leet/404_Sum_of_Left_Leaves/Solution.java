class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root);
    }
    int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null) {
            return sum(node.right);
        }
        if (node.left.left == null && node.left.right == null) {
            return node.left.val + sum(node.right);
        }
        else {
            return sum(node.left) + sum(node.right);
        }
    }
    public static void main(String[] args) {
        
    }
}