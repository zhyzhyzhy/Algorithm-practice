import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,1,2,4,3,4,5};
        // System.out.println(solution.getTargetNumber(nums));
        System.out.println(Arrays.toString(solution.getTargetNumbers(nums)));

    }
    //一个数组中除了一个数出现了一次，其他的都出现了两次
    public int getTargetNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            i ^= nums[j];
        }
        return i;
    }
    //一个数组中两个数字出现了一次，其他的都出现了两次
    public int[] getTargetNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] targets = new int[2];

        int i = nums[0];
        for (int j = 1; j < nums.length; j++) {
            i ^= nums[j];
        }
        int index = 0;
        while ((i & 1) != 1) {
            i = i >> 1;
            index++;
        }
        for (i = 1; index > 0; index--) {
            i = i << 1;
        }
        for (int j = 0; j < nums.length; j++) {
            if ((i & nums[j]) == 0) {
                targets[0] ^= nums[j];
            }
            else {
                targets[1] ^= nums[j];
            }
        }
        return targets;
    }
}
