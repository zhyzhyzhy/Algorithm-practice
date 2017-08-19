public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProductSubstring(new int[]{-2,4,0,3,1,8,-1}));
    }
    public int maxProductSubstring(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        int i = 1;
        while (i < nums.length - 1) {
            if (nums[i] < 0) {
                int temp = currentMin;
                currentMin = currentMax;
                currentMax = temp;
            }
            currentMax = Math.max(currentMax * nums[i], nums[i]);
            currentMin = Math.max(currentMin * nums[i], nums[i]);
            max = Math.max(max, currentMax);
            i++;
        }
        return max;
    }
}