public class Solution {
    public boolean canJump(int[] nums) {
        int i = nums.length - 2;
        int end = nums.length - 1;
        while (i > 0) {
            if (i + nums[i] >= end) {
                end = i;
            } 
            i--;
        }
        if (nums[0] >= end) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}