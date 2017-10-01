/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/09/11 - 18:54:29
*/
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.verifySquenceOfBST(new int[]{5,7,6,9,11,10,8}));
		System.out.println(solution.verifySquenceOfBST(new int[]{7,4,6,5}));
	}
	public boolean verifySquenceOfBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return true;
		}
		return recursionVerifySquenceOfBST(nums, 0, nums.length - 1);
	}
	public boolean recursionVerifySquenceOfBST(int[] nums, int begin, int end) {
		if (begin >= end) {
			return true;
		}
		int rootNum = nums[end];
		int i = begin;
		while (i < end && nums[i] < rootNum) {
			i++;
		}
		for (int j = i + 1; j <= end; j++) {
			if (nums[j] < rootNum) {
				return false;
			}
		}
		return recursionVerifySquenceOfBST(nums, begin, i - 1) && recursionVerifySquenceOfBST(nums, i, end - 1);
	}
}

