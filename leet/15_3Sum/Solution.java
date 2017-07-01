import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists  = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (Arrays.binarySearch(nums, j + 1, nums.length, 0 - nums[i] - nums[j]) > 0) {
                    // System.out.println("i = " + i + " j = " + j);
                    lists.add(Arrays.asList(nums[i], nums[j], 0 - nums[i] - nums[j]));
                }
            }
        }      
        return lists;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{0,0,0,0}));
    }
}