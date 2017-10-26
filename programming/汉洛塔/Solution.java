/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/26 - 18:32:31
*/
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.hanoiProblem(2,"left", "right", "mid");
	}
	public void hanoiProblem(int num, String from, String to, String mid) {
		if (num <= 1) {
			System.out.println("move " + 1 + " from " + from + " to " + to);
			return;
		}
		hanoiProblem(num - 1, from, mid, to);
		System.out.println("move " + num + " from " + from + " to " + to);
		hanoiProblem(num - 1, mid, to, from);
	}
}

