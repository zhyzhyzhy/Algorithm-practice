import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isOrdered(new int[]{1,2,3,0,0}));
    }


    //大小王为0
    public boolean isOrdered(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        int notZeroIndex = 0;
        for (notZeroIndex = 0; notZeroIndex < nums.length; notZeroIndex++) {
            if (nums[notZeroIndex] == 0) {
                zeroCount++;
            }
            else {
                break;
            }
        }
        for (; notZeroIndex < nums.length - 1; notZeroIndex++) {
            zeroCount -= nums[notZeroIndex+1] - nums[notZeroIndex] - 1;
        }
        return zeroCount >=0;
    }
}
