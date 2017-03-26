class Solution {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        getDeep(root);
        return max;
    }

    public int getDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int deepLeft = getDeep(node.left);
        int deepRight = getDeep(node.right);
        int deep = deepLeft + deepRight;
        if (deep > max) {
            max = deep;
        }
        return Math.max(deepLeft, deepRight) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}