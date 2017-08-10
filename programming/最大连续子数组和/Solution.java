public class Solution {
    public static void main(String[] args) {
        System.out.println(MaxSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5})); 
    }
    public static int MaxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currentMax = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currentMax = currentMax + nums[i] > nums[i] ? currentMax + nums[i] : nums[i];
            max = Math.max(currentMax, max);
        }
        return max;
    }
}