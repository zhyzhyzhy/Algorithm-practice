//一开始准备用targetSum的方式写的，但是会超时
//看了讨论中的一个用boolean数组的解法，很神奇
/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/04/17 - 15:07:33
*/
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.canPartition(new int[]{1,1,1,1}));
	}
	public boolean canPartition(int[] nums) {
		int judge    = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			judge   += nums[i];
		}
		if (judge%2 == 1) {
			return false;
		}
		int[][] dp = new int[nums.length][judge/2 + 1];
		for (int i = nums[0]; i < judge/2+1; i++ ) {
			dp[0][i] = nums[0];
		}
		for (int i = 1; i < nums.length; i++) {
			for (int j = nums[i]; j <= judge/2; j++) {
				if ( dp[i-1][j] > dp[i-1][j-nums[i]] + nums[i]) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j-nums[i]] + nums[i];
				}
			}
		}
		System.out.println(dp[nums.length-1][judge/2]);
		if (dp[nums.length-1][judge/2] == judge/2) {
			return true;
		}
		return false;
    }
}
