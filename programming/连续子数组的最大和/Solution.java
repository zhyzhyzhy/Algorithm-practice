/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/09/26 - 13:11:43
*/
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxSubArr(new int[]{1,-2,3,10,-4,7,2,-5}));
	}
	public int maxSubArr(int[] nums) {
		int max = nums[0];
		int currentMax = nums[0];

		for (int i = 1; i < nums.length; i++) {
			currentMax = currentMax + nums[i] > nums[i] ? currentMax + nums[i]: nums[i];
			max = max > currentMax ? max : currentMax;
		}
		return max;
	}
}

