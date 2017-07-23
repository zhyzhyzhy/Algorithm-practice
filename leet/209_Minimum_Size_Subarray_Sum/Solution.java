import java.util.*;
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0 || s <= 0) {
            return 0;
        }
        int minLen = nums.length + 1;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= s) {
                minLen = minLen > (j - i) ? j - i : minLen;
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
    }
}