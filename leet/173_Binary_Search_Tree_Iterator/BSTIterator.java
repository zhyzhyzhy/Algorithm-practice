import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class BSTIterator{

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        addAll(root);
    }

    public void addAll(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode node2 = node;
        stack.push(node2);
        while(node2.left != null) {
            stack.push(node2.left);
            node2 = node2.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty(); 
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        addAll(node.right);
        return node.val; 
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */