/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/19 - 00:04:39
*/
class Solution {
	//根据讨论来的
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[start]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else if (nums[mid] < nums[end]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
	//自己写的，效率不行
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left;
        int right;
        int indexOfMax = findBiggestIndex(nums);
        if (target >= nums[0]) {
            left = 0;
            right = indexOfMax;
        }
        else {
            left = indexOfMax + 1;
            right = nums.length - 1;
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
               left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    public int findBiggestIndex(int[] nums) {
        int length = nums.length;
        if (nums[0] <= nums[length - 1]) {
            return length - 1;
        }
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if ((mid + 1 >= length || nums[mid] > nums[mid + 1] ) && (mid - 1 < 0 || nums[mid] > nums[mid - 1])) {
                return mid;
            }
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            }
            else if (nums[mid] >= nums[0]) {
                left = mid + 1;
            }
        }
        return left;
    }
}
