import java.util.Stack;

//两个栈实现一个队列
public class Solution<T> {
    public static void main(String[] args) {
        
    }

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();
    private int count = 0;
    public boolean add(T element) {
        count++;
        return stack1.add(element);
    }

    public T remove() {
        if (count == 0) {
            throw new NullPointerException();
        }
        if (stack2.size() == 0) {
            while (stack1.size() != 0) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }
}