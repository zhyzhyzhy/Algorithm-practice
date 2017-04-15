//开始是自己想多了
//状态转移方程
//dp[i] = Max(sum[i - 2] + dp[i], sum[i - 1])
public class Solution {
    public static int rob(int[] nums) {
    	int length = nums.length;
    	if (length == 0) {
    		return 0;
    	}
    	if (length == 1) {
    		return nums[0];
    	}
    	if (length == 2) {
    		return nums[0] > nums[1] ? nums[0] : nums[1];
    	}
    	int[] dp = new int[length];
    	if (nums[0] >= nums[1]) {
    		dp[0] = nums[0];
    		dp[1] = nums[0];
    	}
    	else {
    		dp[0] = nums[0];
    		dp[1] = nums[1];
    	}
    	for (int i = 2; i < length; i++) {
    		if (dp[i - 2] + nums[i] > dp[i-1]) {
    			dp[i] = nums[i] + dp[i - 2];
    		} else {
    			dp[i] = dp[i - 1];
    		}
    	}
    	return dp[length - 1];
    }
    public static void main(String[] args) {
    	
    }
}
