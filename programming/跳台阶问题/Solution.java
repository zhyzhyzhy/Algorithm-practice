
/*
一个台阶总共有n 级，如果一次可以跳1 级，也可以跳2 级。

求总共有多少总跳法，并分析算法的时间复杂度。

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countOfJump3(4, 2)); 
    }
    //开了n的数组
    public int countOfJump1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    //不开n数组
    public int countOfJump2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[4];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[3] = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }

    //如果一次可以最多跳k级
    public int countOfJump3(int n, int k) {
        if (k == 1) return 1;
        int[] dp = new int[k + 2];
        dp[1] = 1;
        for (int i = 2; i < k + 1; i++) {
            dp[i] = dp[i - 1] * 2;
        }

        for (int i = k + 1; i < n + 1; i++) {
            dp[k + 1] = 0;
            for (int j = 1; j < k + 1; j++) {
                dp[k + 1] += dp[j];
            }
            for (int j = 0; j < k + 1; j++) {
                dp[j] = dp[j + 1];
            }
        }
        return dp[k + 1];
    }
}