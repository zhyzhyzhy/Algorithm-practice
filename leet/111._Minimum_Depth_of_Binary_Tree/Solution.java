import java.util.Queue;
import java.util.LinkedList;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public static int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int min = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                TreeNode node = queue.poll();
                size--;
                if (node.left == null && node.right == null) {
                    return min;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            min++;
        }
        return min;
    }
    public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       root.left.left = new TreeNode(4);
       root.right.left = new TreeNode(6);
       root.right.left.left = new TreeNode(6);
       root.right.right = new TreeNode(7); 
       System.out.println(minDepth(root));
    }
}
