import java.util.Arrays;

public class Solution {

    //类似于快排，找到第k大的数，前k个就是最小的
    public void quickSelect(int[] nums, int k) {
        recurisonSelect(nums, k, 0, nums.length - 1);
    }
    public void recurisonSelect(int[] nums, int k, int left, int right) {
        int key = nums[left];
        int tempRight = right;
        while (left < right) {
            while (right > left && nums[right] > key) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] < key) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = key;
        if (left > k - 1) {
            recurisonSelect(nums, k, 0, left - 1);
        }
        else if (left < k - 1) {
            recurisonSelect(nums, k, left + 1, tempRight);
        }
        return;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,3,43,21,3,5,7};
        solution.quickSelect(nums, 4);
        System.out.println(Arrays.toString(nums));
    }
}