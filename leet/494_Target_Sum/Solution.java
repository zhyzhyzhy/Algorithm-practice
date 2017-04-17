//暴力
//加上减枝
import java.util.Arrays;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/04/17 - 08:54:45
*/
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
	}
	private int total = 0;
	public int findTargetSumWays(int[] nums, int S) {
		int[] sum = new int[nums.length + 1];
		int[] minus = new int[nums.length + 1];
		for (int i = nums.length - 1; i >= 0; i--) {
			sum[i] = nums[i] + sum[i+1];
			minus[i] = minus[i+1] - nums[i];
		}
		System.out.println(Arrays.toString(sum));
		System.out.println(Arrays.toString(minus));
		getTotal(1, nums[0], nums, S, sum, minus);
		getTotal(1, 0-nums[0], nums, S, sum, minus);
		return total;
    }
	public void getTotal(int i, int currentValue, int[] nums, int S, int[] sum, int[] minus) {
		if (i == nums.length) {
			if (currentValue == S)
				total++;
			return;
		} else if ( currentValue + sum[i] < S || currentValue + minus[i] > S) {
			return;
		} else {
			getTotal(i+1,currentValue + nums[i], nums, S, sum, minus);
			getTotal(i+1,currentValue - nums[i], nums, S, sum, minus);
		}
	}
}

