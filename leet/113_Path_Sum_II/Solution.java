import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Solution {
    private List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recursion(sum, 0, new ArrayList<Integer>(), root);
        return lists;
    }
    public void recursion(int target, int currentSum, List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        if (currentSum + node.val == target && node.left == null && node.right == null) {
            list.add(node.val);
            lists.add(new ArrayList(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(node.val);
        recursion(target, currentSum + node.val, list, node.left);
        recursion(target, currentSum + node.val, list, node.right);
        list.remove(list.size() - 1);
        
    }
    public static void main(String[] args) {
        
    }
}