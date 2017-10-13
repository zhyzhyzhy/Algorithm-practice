class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return recursionBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode recursionBuildTree(int[] preorder, int[] inorder, 
                                        int preLeft, int preRight,
                                        int inLeft, int inRight) 
    {
        if (preRight < preLeft || inRight < inLeft) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preLeft]);
        int index;
        for (index = 0; index <= inRight; index++) {
            if (inorder[index] == preorder[preLeft]) {
                break;
            }
        }
        if (index == inRight + 1) {
            return node;
        }
        node.left = recursionBuildTree(preorder, inorder, preLeft + 1, preLeft + 1 + index - inLeft, inLeft, index - 1);
        node.right = recursionBuildTree(preorder, inorder,preLeft + 1 + index - inLeft, preRight, index + 1, inRight);
        return node;
    }

    //ABCDEFG
    //CBDAEGF
    //1234
    //1234
     //   1
       //     2
         //       3
           //         4
}
