/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/23 - 16:47:32
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
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        recursionTree2str(t, builder);
        return builder.toString();
    }
    public void recursionTree2str(TreeNode t, StringBuilder builder) {
        if (t == null) {
            return;
        }
        builder.append(t.val);
        if (t.right != null || t.left != null) {
            builder.append("(");
            recursionTree2str(t.left, builder);
            builder.append(")");
        }
        if (t.right != null ) {
            builder.append("(");
            recursionTree2str(t.right, builder);
            builder.append(")");
        }
        
       
    }
}
