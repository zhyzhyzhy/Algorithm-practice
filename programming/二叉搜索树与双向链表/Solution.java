class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(10);
        root.left  = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
		root = solution.convert(root);
		TreeNode temp = null;
		while (root != null) {
			temp = root;
			root = root.right;
		} 
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.left;
		}
    }
    public TreeNode convert(TreeNode root) {
		recursionConvert(root, 0);
        return root;
    }
    public TreeNode recursionConvert(TreeNode node, int direction) {
        if (node == null) {
            return null;
        }
        node.left = recursionConvert(node.left, 1);
		if (node.left != null) {
			node.left.right = node;
		}
        node.right = recursionConvert(node.right, 0);
		if (node.right != null) {
			node.right.left = node;
		}
		if (direction == 0 && node.left != null) {
			return node.left;
		}
		else if (direction == 1 && node.right != null ) {
			return node.right;
		}
		return node;
    }
} 
