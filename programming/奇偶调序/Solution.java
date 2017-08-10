import java.util.Arrays;

/*
输入一个整数数组，调整数组中数字的顺序，使得所有奇数位于数组的前半部分，
所有偶数位于数组的后半部分。要求时间复杂度为O(n)。

*/

public class Solution {
    public boolean idOdd(int num) {
        return (num & 1) == 1;
    }
    public int[] oddEvenSort(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && idOdd(nums[left])) {
                left++;
            } 
            while (left < right && !idOdd(nums[right])) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.oddEvenSort(new int[]{2, 8,7, 1, 3, 5, 6, 4})));
    }
}