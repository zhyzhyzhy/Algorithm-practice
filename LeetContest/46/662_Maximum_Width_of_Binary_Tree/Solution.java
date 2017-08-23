import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    //太慢了。。。思路是空的补一个-100的节点继续往下一层找。
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int max = 1;
        int currentMax = 1;
        int count = 1;
        int height = 1;
        int currentCount = 0;
        int left = height;
        int right = 1;
        int nullCount = 0;
        TreeNode node = null;
        TreeNode temp = new TreeNode(-100);
        while (queue.size() != 0) {
            currentCount = 0;
            nullCount = 0;
            height *= 2;
            left = height;
            right = 1;
            while (count > 0) {
                node = queue.remove();
                currentCount += 2;
                if (node.left != null) {
                    queue.add(node.left);
                    if (left == height && node.val != -100) {
                        left = currentCount - 1;
                    }
                    if (node.val != -100) {
                        right = currentCount - 1;
                    }
                }
                else {
                    queue.add(temp);
                    nullCount++;
                }

                if (node.right != null) {
                    queue.add(node.right);
                    if (left == height && node.val != -100) {
                        left = currentCount;
                    }
                    if (node.val != -100) {
                        right = currentCount;
                    }
                }
                else {
                    queue.add(temp);
                    nullCount++;
                }
                count--;
            }
            if (nullCount == height) {
                break;
            }
            currentMax = right - left + 1;
            count = queue.size();
            max = max > currentMax? max: currentMax;
        }
        return max;
    }


    //看的讨论，，用dfs做
    public int widthOfBinaryTree1(TreeNode root) {
        return recursion(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
    public int recursion(TreeNode node, int level, int index,
                         ArrayList<Integer> start, ArrayList<Integer> end) {
        if (node == null) {
            return 0;
        }
        if (start.size() == level) {
            start.add(index);
            end.add(index);
        }
        else {
            end.set(level, index);
        }
        int max = start.get(level) - end.get(level) + 1;
        int left = recursion(node.left, level + 1, index * 2, start, end);
        int right = recursion(node.right, level + 1, index *2 + 1, start, end);
        return Math.max(max, Math.max(left,right));
    }
    public static void main(String[] args) {
        
    }
}