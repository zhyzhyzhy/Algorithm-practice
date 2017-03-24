public class Solution {
    public static void main(String[] args) {
        
    }
    public  TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
    public  TreeNode delete(TreeNode x, int key) {
        if (x == null) {
            return null;
        }
        int cmp = x.val - key;
        if(cmp > 0) {
            x.left = delete(x.left, key);
        }
        else if(cmp < 0) {
            x.right = delete(x.right, key);
        }
        else {
            if(x.right != null) {
                int min = findMin(x.right); 
                x.val = min;
                x.right = delete(x.right, min);
            }
            else {
                x = x.left;
            }
        }
        return x;
    }

    public int findMin(TreeNode x) {
        while(x.left != null) {
            x = x.left;
        }
        return x.val;
    }
}
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}