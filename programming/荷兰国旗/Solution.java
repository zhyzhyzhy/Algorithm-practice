import java.util.Arrays;

/*
下面是问题的正规描述： 现有n个红白蓝三种不同颜色的小球，乱序排列在一起，
请通过两两交换任意两个球，使得从左至右，依次是一些红球、一些白球、一些蓝球。

*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,1,0,1,2,0,0,1,2,0,2,1,1,2,1,0,0,1};
        solution.gnuhpc(nums);
        System.out.println(Arrays.toString(nums));
    }
    //red 0
    //white 1
    //blue 2
    //感觉分奇偶也可以用这个方法
    public void gnuhpc(int[] nums) {
        int begin = 0;
        int current = 0;
        int end = nums.length - 1;
        while (current < end) {
            if (nums[current] == 0) {
                swap(nums, begin++, current++);
            }
            else if (nums[current] == 1) {
                current++;
                continue;
            }
            else {
                swap(nums, current, end--);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}