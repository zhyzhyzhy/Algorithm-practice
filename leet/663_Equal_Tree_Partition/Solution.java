import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean checkEqualTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int sum = sumOfTree(root, set);
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (set.contains(target)) return true;
        return false;

    }

    public int sumOfTree(TreeNode node, Set<Integer> set) {
        if (node == null) {
            return 0;
        }
        else {
            int cur = node.val + sumOfTree(node.left, set) + sumOfTree(node.right, set);
            set.add(cur);
            return cur;

        }
    }
    public static void main(String[] args) {
        
    }
}