import java.util.*;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override  
            public int compare(int[] o1, int[] o2) {  
                return o1[0] - o2[0];
            } 
        });
        for (int i = 0; i < pairs.length; i++) {
            int max = 1;
            for (int k = 0; k < i; k++) {
                if (pairs[k][1] < pairs[i][0]) {
                    max = Math.max(dp[k] + 1, max);
                }
                else {
                    max = Math.max(dp[k], max);
                }
            }
            dp[i] = max;
        }
        return dp[pairs.length - 1];
    }
}