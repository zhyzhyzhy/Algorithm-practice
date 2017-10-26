import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/26 - 19:40:49
*/
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[]{4,1,2,2,1,3,6,7,8};
		System.out.println(Arrays.toString(solution.matrixOfMax(nums, 3)));
	}
	public int[] matrixOfMax(int[] nums, int n) {
		int[] max = new int[nums.length - n + 1];
		Deque<Integer> queue = new LinkedList<>();
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (queue.isEmpty()) {
				queue.addFirst(i);
			}
			else if(nums[i] < nums[queue.peekLast()]) {
				queue.addLast(i);
			}
			else {
				while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
					queue.pollLast();
				}
				queue.addLast(i);
			}
			while ( i - n +1 > queue.peekFirst()) {
				queue.pollFirst();
			}
			if (i >= n - 1) {
				max[index++] = nums[queue.peekFirst()];
			}
		}
		return max;
	}
}

