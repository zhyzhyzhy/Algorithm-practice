public class Solution {
    public static void main(String[] args) {
        
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while(root != null) {
            list.add(root.val);
            root = root.right;
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
