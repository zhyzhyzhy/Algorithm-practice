public class Solution {
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int index = left + (right - left) / 2;
            if (nums[index] > nums[index - 1] && nums[index] > nums[index + 1]) {
                return index;
            }
            else if (nums[index] > nums[index - 1]) {
                left = index + 1;                
            }
            else {
                right = index - 1;
            }
        }
        return nums[left] > nums[right] ? left : right;

    }
    public static void main(String[] args) {
        System.out.println( findPeakElement(new int[]{3,4,3,2,1}));
    }
}