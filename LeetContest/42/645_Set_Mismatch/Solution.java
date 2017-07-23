import java.util.*;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i]) == false) {
                result[0] = nums[i];
            }    
        }
        for (int i = 1; i <= nums.length; i++) {
            if (set.add(i) == true) {
                result[1] = i;
            }
        }
        return result;
    }
}