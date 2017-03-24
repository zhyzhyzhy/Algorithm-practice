public class Solution {
    public static void main(String[] args) {

    }
    public boolean hasPathSum(TreeNode root, int sum) {
        int tempSum = 0;
        if(root == null)
            return false;
        return Sum(root, tempSum, sum);
    }
    public boolean Sum( TreeNode x, int tempSum, int sum) {
        if(x.left == null && x.right == null){
            tempSum += x.val;
            if(tempSum == sum)
                return true;
            return false;
        }
        else if(x.left == null) {
            tempSum += x.val;
            return Sum(x.right, tempSum, sum);
        }
        else if(x.right == null) {
            tempSum += x.val;
            return Sum(x.left, tempSum, sum);
        }
        else {
            tempSum += x.val;
            return Sum(x.left, tempSum, sum) || Sum(x.right, tempSum, sum);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if(root == null)
            return list;
        if(root.left == null && root.right == null) {
            list.add(root.val+"");
            return list;
        }
        String begin = root.val + "";
        Path(root.left, list, begin);
        Path(root.right, list, begin);
        return list;
    }
    public void Path(TreeNode x, List<String> list, String path) {
        if(x == null)
            return;
        else if(x.left == null && x.right == null) {
            path = path + "->" + x.val;
            list.add(path);
        }
        else if(x.left == null) {
            path = path + "->" + x.val;
            Path(x.right, list, path);
        }
        else if(x.right == null){
            path = path + "->" + x.val;
            Path(x.left, list, path);
        }
        else {
            path = path + "->" + x.val;
            Path(x.left, list, path);
            Path(x.right, list, path);
        }
    }

}
class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int x) { val = x; }
}
