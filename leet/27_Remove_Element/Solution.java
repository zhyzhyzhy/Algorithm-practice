//小题坑反而多
public class Solution {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }        
        int left = 0;
        int right = nums.length - 1;
            while (left <= right && nums[right] == val ) {
                right--;
            }
        while ( left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                nums[right] = val;
                left++;
                right--;
            }
            else {
                left++;
            }
            while ( left <= right && nums[right] == val) {
                right--;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        
    }
}