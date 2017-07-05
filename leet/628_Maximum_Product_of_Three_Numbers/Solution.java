import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a = nums[nums.length - 3] * nums[nums.length - 1] * nums[nums.length - 2];
        int b = nums[0] * nums[1] * nums[nums.length - 1];
        return a > b? a : b;
    }
}