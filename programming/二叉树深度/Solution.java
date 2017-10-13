class TreeNode {
    int val;
    TreeNode(int x) {
        this.val = x;
    }
    TreeNode left;
    TreeNode right;

}
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);

        Solution solution = new Solution();
        System.out.println(solution.depthOfTree(root));
    }

    private int depth;
    public int depthOfTree(TreeNode root) {
        if (root == null) {
            return depth;
        }
        getDepthOfTree(root);
        return depth;
    }
    public int getDepthOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int tempDepth = Math.max(getDepthOfTree(node.left), getDepthOfTree(node.right)) + 1;
        if (tempDepth > depth) {
            depth = tempDepth;
        }
        return tempDepth;
    }

}