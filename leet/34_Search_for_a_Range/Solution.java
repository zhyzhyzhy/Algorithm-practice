/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/24 - 16:40:59
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                res[0] = findleft(nums, mid);
                res[1] = findright(nums, mid);
                break;
            }
        }
        return res;
    }
    public int findleft(int[] nums, int index) {
        int target = nums[index];
        if (index == 0) {
            return 0;
        }
        int left = 0;
        int right = index;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] != target && nums[mid + 1] == target) {
                return mid + 1;
            }
            else if(nums[mid] == target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    public int findright(int[] nums, int index) {
        //System.out.println(index);
        int target = nums[index];
        if (index == nums.length - 1) {
            return index;
        }
        int left = index;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target && (mid + 1 >= nums.length || nums[mid + 1] != target)) {
                return mid;
            }
            else if(nums[mid] == target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
