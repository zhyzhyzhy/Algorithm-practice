class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if ((s == null && t == null) || t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }

        if (s.val == t.val) {
            if (compareTree(s, t)) {
                return true;
            }
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean compareTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null && t != null && s.val == t.val) {
            return compareTree(s.left, t.left) && compareTree(s.right, t.right);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}