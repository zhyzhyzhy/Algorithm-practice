//把一个数组的最开始的若干元素搬到数组的末尾，我们称之为数组的旋转
//输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
//[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{1,0,1,1,1}));
    }
    public int findMin(int[] nums) {
        if (nums.length == 0)  {
            throw new NullPointerException();
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[0]) {
                left = mid;
            }
            else if(nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            else {
                right = mid;
            }
        }
        return nums[right];
    }
}