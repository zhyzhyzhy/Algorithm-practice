import java.util.Stack;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/23 - 18:13:21
*/
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(3);
		stack.push(1);
		stack.push(6);
		stack.push(5);
		solution.sortStack1(stack);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	public void sortStack1(Stack<Integer> stack) {
		Stack<Integer> sortStack = new Stack<>();
		while (!stack.isEmpty()) {
			int num = stack.pop();
			while (!sortStack.isEmpty() && num > sortStack.peek()) {
				stack.push(sortStack.pop());
			}
			sortStack.push(num);
		}
		while (!sortStack.isEmpty()) {
			stack.push(sortStack.pop());
		}
	}
	public void sortStack(Stack<Integer> stack) {
		Stack<Integer> sortStack = new Stack<>();
		int length = stack.size();
		int before;
		int current;
		for (int j = length - 1; j > 0; j--) {
			before = stack.pop();
			for (int i = 0; i < j; i++) {
				current = stack.pop();
				if (current < before) {
					sortStack.push(before);
					before = current;
				}
				else {
					sortStack.push(current);
				}
			}
			sortStack.push(before);
			int size = sortStack.size();
			for (int k = 0; k < size; k++) {
				stack.push(sortStack.pop());
			}
		} 
	}
}

