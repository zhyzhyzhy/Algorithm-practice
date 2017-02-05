public class Solution {
    public static void main(String[] args) {
        
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
 
