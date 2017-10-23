/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/19 - 17:03:47
*/
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		//solution.printStack(stack);
		solution.reverseStack(stack);
		solution.printStack(stack);
	}
	public void printStack(Stack<Integer> stack) {
		while (stack.size() > 0) {
			System.out.println(stack.pop() + " ");
		}
	}
	public void reverseStack(Stack<Integer> stack) {
		if (stack.size() == 0) {
			return;
		}
		int result = getLastEle(stack);
		reverseStack(stack);
		stack.push(result);
	}
	public int getLastEle(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.size() == 0) {
			return result;
		}
		int last = getLastEle(stack);
		stack.push(result);
		return last;
	}
}
