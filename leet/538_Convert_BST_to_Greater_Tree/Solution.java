//写复杂了,看看讨论
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/04/19 - 15:45:17
*/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



public class Solution {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);
		Solution solution = new Solution();
		solution.convertBST(root);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
	}

	List<Integer> list = new ArrayList<>();
    public TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return null;
		}
		dfs(root);
		Integer[] sum = list.toArray(new Integer[list.size()]);
		Arrays.sort(sum);
		int[] newSum = new int[sum.length];
		System.out.println(Arrays.toString(sum));
		for (int i = sum.length - 2; i >= 0; i--) {
			newSum[i] = newSum[i + 1] + sum[i + 1];
		}
		System.out.println(Arrays.toString(newSum));
		dfs1(root, sum, newSum);
		return root;
    }

	public void dfs(TreeNode node) {
		if (node == null) {
			return;
		}
		else {
			list.add(node.val);
			dfs(node.left);
			dfs(node.right);
		}
	}
	public void dfs1(TreeNode node, Integer[] sum, int[] newSum) {
		if (node == null) {
			return;
		}
		int val = node.val;
		int i = 0;
		while(i < sum.length - 1 && val > sum[i]){
			i++;
		}
		System.out.println(node.val + "   " + i);
		node.val += newSum[i];
		dfs1(node.left, sum, newSum);
		dfs1(node.right, sum, newSum);
	}


}

