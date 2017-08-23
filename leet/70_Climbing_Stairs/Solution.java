class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int i = 1;
        int j = 2;
        int k = i + j;
        for (int m = 3; m <= n; m++) {
            k = i + j;
            i = j;
            j = k;
        }
        return k;
    }
}