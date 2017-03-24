package Search;

/**
 * Created by zhy on 1/31/17.
 */
//二叉查找树
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    //Node类
    private class Node {
        Key key;
        Value value;
        int size;
        Node left;
        Node right;
        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.size = 1;
        }
    }


    //插入一组键值
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }
    private Node put(Node x, Key key, Value value) {
        if(x == null)
            return new Node(key, value);
        int i = x.key.compareTo(key);
        if (i < 0)
             x.right = put(x.right, key, value);
        else if (i > 0)
             x.left = put(x.left, key, value);
        else
            x.value = value;
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    //得到一个剪的值
    public Value get(Key key) {
        return get(root, key).value;
    }
    private Node get(Node x, Key key) {
        if(x == null)
            return null;
        int i = x.key.compareTo(key);
        if(i == 0)
            return x;
        if(i > 0)
            return get(x.left, key);
        else
            return get(x.right, key);

    }

    //得到整个树的节点数
    public int size() {
        return size(root);
    }
    //得到某个节点为根的节点数
    private int size(Node x) {
        if(x == null)
            return 0;
        else
            return x.size;
    }

    //删除最大剪
    public void delMax() {
        root = delMax(root);
    }
    private Node delMax(Node x) {
        if(x.right == null)
            return x.left;
        x.right = delMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    //删除最小剪
    public void delMin() {
        root = delMin(root);
    }
    private Node delMin(Node x) {
        if(x.left == null)
            return x.right;
        x.left = delMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    //返回最大剪
    public Value Max() {
        return Max(root).value;
    }
    private Node Max(Node x) {
        if(x.right == null)
            return x;
        return Max(x.right);
    }

    //返回最小剪
    public Value Min() {
        return Min(root).value;
    }

    private Node Min(Node x) {
        if(x.left == null)
            return x;
        return Min(x.left);
    }

    //删除一个剪
    public void delNode(Key key) {
        root = delNode(root, key);
    }
    private Node delNode(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = x.key.compareTo(key);
        if (cmp < 0){
            x.right = delNode(x.right, key);
        }
        else if (cmp > 0) {
            x.left = delNode(x.left, key);
        }
        else {
            if (x.left == null)
                return x.right;
            else if(x.right == null)
                return x.left;
            Node min = Min(x.right);
            min.left = x.left;
            min.right = delMin(x.right);
            x = min;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

}
