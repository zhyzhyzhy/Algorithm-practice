import Search.BST;

/**
 * Created by zhy on 1/31/17.
 */
public class Main {
    public static void main(String[] args) {
        BST bst = new BST<Integer, String>();
        bst.put(22, "zhuyichen");
        bst.put(21, "maoshumin");
        bst.put(221, "love");
        System.out.println(bst.Max());
        bst.delNode(221);
        System.out.println(bst.Max());
    }
}
