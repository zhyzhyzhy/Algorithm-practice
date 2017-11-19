/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/11/18 - 11:06:24
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean left = false;
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            if (left) {
                List<Integer> list = new ArrayList<>();
                while (length > 0) {
                    TreeNode node = deque.pollLast();
                    list.add(node.val);
                    length--;
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                }
                left = false;
                lists.add(list);
            }
            else {
                List<Integer> list = new ArrayList<>();
                while (length > 0) {
                    TreeNode node = deque.pollFirst();
                    list.add(node.val);
                    length--;
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                }
                left = true;
                lists.add(list);
            }
        }
        return lists;
    }
}
