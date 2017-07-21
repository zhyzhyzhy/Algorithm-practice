/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/07/20 - 12:16:36
*/
public class Solution{
	public static void main(String[] args) {

	}
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		k = nums.length - k - 1;
		rotateSub(nums, 0, k);
		rotateSub(nums, k + 1, nums.length - 1);
		rotateSub(nums, 0 , nums.length - 1);
    }
	public void rotateSub(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}

