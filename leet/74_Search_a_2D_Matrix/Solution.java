/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/28 - 16:56:43
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int width = matrix[0].length - 1;
        int top = 0;
        int down = matrix.length - 1;
        while (top <= down) {
            int mid = (top + down) >> 1;
            if (target > matrix[mid][width]) {
                top = mid + 1;
            }
            else {
                if (target >= matrix[mid][0]) {
                    return search(matrix[mid], target);
                }
                else {
                    down = mid - 1;
                }
            }
        }
        return false;
    }
    public boolean search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] == target) {
                return true;
            }
            else if(arr[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}
