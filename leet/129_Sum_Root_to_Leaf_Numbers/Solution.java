

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root,"");
    }
    public int dfs(TreeNode node, String number) {
        if (node.left == null && node.right == null) {
            return Integer.parseInt(number + node.val);
        }
        else if (node.left == null && node.right != null) {
            return dfs(node.right, number + node.val);
        }
        else if (node.left != null && node.right == null) {
            return dfs(node.left, number + node.val);
        }    
        else {
            return dfs(node.right, number + node.val) + dfs(node.left, number + node.val);
        }
    }
    public static void main(String[] args) {
        
    }
}