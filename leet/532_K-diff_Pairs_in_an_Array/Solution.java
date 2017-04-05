import java.util.Arrays;


public class Solution {
    public static void main(String[] args) {
       Solution solution = new Solution();
       System.out.println(solution.findPairs(new int[]{1,3,1,5,4}, 0));
    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;                
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == k) {
                    count++;
                    break;
                }
                else if (nums[j] - nums[i] > k) {
                    break;
                }
            }
        }
        return count;
    }
}