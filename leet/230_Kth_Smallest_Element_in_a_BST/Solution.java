//虽然不优雅，但是效率高。。。
/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/05/08 - 15:27:23
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		System.out.println(solution.kthSmallest(root, 2));
	}
	private int i = 0;
    public int kthSmallest(TreeNode root, int k) {
		getEle(root, k);
		return i;
    }
	public boolean getEle(TreeNode node, int k) {
		if (node == null) {
			return false;
		}
		else {
			if (getEle(node.left,  k) == true) {
				return true;
			}
			i++;
			if (i == k) {
				i = node.val;
				return true;
			}
			if (getEle(node.right, k) == true) {
				return true;
			}
			else {
				return false;
			}
		}
	}
}
