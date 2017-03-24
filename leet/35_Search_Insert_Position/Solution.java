public class Solution {
    public int searchInsert(int[] nums, int target) {
    	if (nums.length == 0) {
    		return 0;
    	}
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
    	int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left)/2;
        while (right > left) {
            if (nums[left] == target) {
                return left;
            } 
            else if (nums[right] == target) {
                return right;
            }
            else if (nums[mid] > target) {
                right = mid;
            }
            else if (nums[mid] < target) {
                left = mid;
            }
            else if (nums[mid] == target) {
                return mid;
            }
            mid  = left + (right - left)/2;
            if (mid == left || mid == right) {
                if (nums[mid] < target) {
                    return left + 1;
                }
                return left;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
    	
    }
}