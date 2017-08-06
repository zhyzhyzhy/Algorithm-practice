class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursionBuilding(nums, 0, nums.length - 1);
    }
    public TreeNode recursionBuilding(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = recursionBuilding(nums, left, maxIndex - 1);
        root.right = recursionBuilding(nums, maxIndex + 1, right);
        return root;
    }
}