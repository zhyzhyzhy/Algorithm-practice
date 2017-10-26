/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/26 - 17:30:55
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int down = n - 1;
        int num = 1;
        while(left <= right) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num;
                num++;
            }
            top++;
            for (int i = top; i <= down; i++) {
                res[i][right] = num;
                num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[down][i] = num;
                num++;
            }
            down--;
            for (int i = down; i >= top; i--) {
                res[i][left] = num;
                num++;
            }
            left++;
        }
        return res;
    }
}
