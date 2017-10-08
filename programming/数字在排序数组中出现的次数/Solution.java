public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getCountOfN(new int[]{1,2,2,2,3,3,4,5}, 2));
    }
    public int getCountOfN(int[] nums, int n) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int existIndex = -1;
        int mid = - 1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < n) {
                left = mid + 1;
            }
            else if (nums[mid] > n) {
                right = mid - 1;
            }
            else {
                existIndex = mid;
                break;
            }
        }
        if (existIndex == -1 && nums[left] != n) {
            return -1;
        }
        if (nums[left] == n) {
            existIndex = left;
        }
        int first = findFirst(nums, n, 0, existIndex);
        int last = findLast(nums, n, existIndex, nums.length - 1);
        return last - first + 1;
    }
    public int findFirst(int[] nums, int n, int start, int end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] < n) {
            return findFirst(nums, n, mid + 1, end);
        }
        else if (mid <= start || nums[mid - 1] != n) {
            return mid;
        }
        return findFirst(nums, n, start, mid - 1);
    }
    public int findLast(int[] nums, int n, int start, int end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] > n) {
            return findFirst(nums, n, start, mid - 1);
        }
        else if (mid >= end || nums[mid + 1] != n){
            return mid;
        }
        return findFirst(nums, n, mid + 1, end);
    }
}