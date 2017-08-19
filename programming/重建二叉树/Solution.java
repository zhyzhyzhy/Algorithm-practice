
//输入某二叉树的前序和后序的结果，重建二叉树
//重建的话，可以当作完全二叉树输出

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int i) {this.val = i;}
}
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] afterOrder = {4,7,2,1,5,3,8,6};
        TreeNode root = solution.rebuildTree(preOrder, afterOrder);
        System.out.println(root.left.left.right.val);
        System.out.println(root.right.right.left.val);
    }
    public TreeNode rebuildTree(int[] preOrder, int[] afterOrder) {
        return recursion(preOrder, afterOrder, 0, preOrder.length - 1, 0, preOrder.length - 1);
    }
    public TreeNode recursion(int[] preOrder, int[] afterOrder, int preLeft, int preRight, int afterLeft, int afterRight) {
        if (preLeft >= preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preLeft]);
        int i = afterLeft;
        while (afterOrder[i] != preOrder[preLeft]) {
            i++;
        }
        root.left = recursion(preOrder, afterOrder, preLeft + 1, preLeft + 1 + i - afterLeft, afterLeft, i);
        root.right = recursion(preOrder, afterOrder, preLeft + i - afterLeft + 1, preRight, i+1, afterRight);
        return root;
    }

}
