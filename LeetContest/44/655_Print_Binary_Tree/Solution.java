import java.awt.List;
import java.util.ArrayList;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {

    private List<List<String>> lists = new ArrayList<>();
    public List<List<String>> printTree(TreeNode root) {
        int colunm = (int)Math.pow(2, getMaxLength(root)) - 1;
        recursionPrintTree(root, colunm, 0, colunm - 1, 0);
        return lists;
    }

    public void recursionPrintTree(TreeNode node, int length, int left, int right, int k) {
        if (node == null) return;
        if (lists.size() < k + 1) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                list.add("");
            }
            lists.add(list);
        }
        List<String> list = lists.get(k);
        
        // list.replaceItem(String.valueOf(node.val), (left + right) / 2);
        list.add((left + right) / 2 , String.valueOf(node.val));
        list.remove((left + right) / 2 + 1);
        recursionPrintTree(node.left, length, left, (left + right) / 2 - 1, k + 1);
        recursionPrintTree(node.right, length, (left + right) / 2 + 1, right, k + 1);

    }
    public int getMaxLength(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getMaxLength(root.left), getMaxLength(root.right));
    }
}