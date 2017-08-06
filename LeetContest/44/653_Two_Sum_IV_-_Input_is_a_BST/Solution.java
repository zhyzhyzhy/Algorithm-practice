import java.util.HashSet;
import java.util.Set;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return recursionSearch(root, k);
    }
    public boolean recursionSearch(TreeNode node, int k) {
        if (node == null) 
            return false;
        if (!set.contains(node.val)) {
            set.add(k - node.val);
            return false || recursionSearch(node.left, k) || recursionSearch(node.right, k);
        }
        return true;
    }
}