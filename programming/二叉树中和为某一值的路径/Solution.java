import java.util.ArrayList;
import java.util.List;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/09/13 - 12:41:04

**/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution{
	public static void main(String[] args) {
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.right = new TreeNode(12);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(7);
		Solution solution = new Solution();
		System.out.println(solution.findPath(node, 22));
	}
	public List<List<Integer>> findPath(TreeNode root, int target) {
		List<List<Integer>> lists = new ArrayList<>();
		recursionFindPath(root, 0, target, new ArrayList<Integer>(), lists);
		return lists;
	}
	public void recursionFindPath(TreeNode node, int currentSum, int target, List<Integer> currentList, List<List<Integer>> lists) {
		if (node == null) {
			return;
		}
		currentSum += node.val;
		if (currentSum > target) {
			return;
		}
		currentList.add(node.val);
		if (currentSum == target) {
			lists.add(new ArrayList<Integer>(currentList));
		}
		recursionFindPath(node.left, currentSum, target, currentList, lists);
		recursionFindPath(node.right, currentSum, target, currentList, lists);
		currentList.remove(currentList.size() - 1);
	}
}

