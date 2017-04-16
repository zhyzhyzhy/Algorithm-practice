/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/04/16 - 10:14:12
*/
public class Solution{
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] {
			-1,-2
		}));
	}
	public static int maxSubArray(int[] nums) {
		int maxCurrent = nums[0];
		int maxEnd = nums[0];
		for (int i = 1; i < nums.length ;i++ ) {
			maxCurrent = Math.max(maxCurrent + nums[i], nums[i]);
			maxEnd = Math.max(maxEnd, maxCurrent);
		}
		return maxEnd;
	}
}

