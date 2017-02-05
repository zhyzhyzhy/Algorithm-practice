import java.util.*;
public class Solution {
    public static void main(String[] args) {
        
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root == null)
            return list;
        queue.add(root);
        while(!queue.isEmpty()) {
            int Size = queue.size();
            List<Integer> newList = new LinkedList<>();
            for (int i = 0; i < Size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
                newList.add(temp.val);
            }
            list.add(newList);
        }
        return list;
    }
}
class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int x) { val = x; }
}
