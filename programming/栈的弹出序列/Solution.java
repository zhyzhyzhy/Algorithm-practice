import java.util.Stack;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/09/06 - 21:36:25
*/
//输入两个序列，比如1，2，3，4，5和4，5，3，2，1
//判断第二个是否能是第一个的栈弹出序列
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isSeq(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
	}
	public boolean isSeq(int[] seq1, int[] seq2) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int j = 0;
		int length = seq1.length;
		while (i < length && j < length) {
			while (i < length && seq1[i] != seq2[j]) {
				stack.push(seq1[i]);
				i++;
			}
			i++;
			j++;
			while (j < length && stack.size() > 0 &&  stack.peek() == seq2[j]) {
				stack.pop();
				j++;
			}
		}
		if (i == length && j == length) {
			return true;
		}
		return false;
	}
}

