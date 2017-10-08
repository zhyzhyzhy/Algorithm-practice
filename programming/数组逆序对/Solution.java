public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.inversePairs(new int[]{7,5,6,4 ,1, 3}));
    }
    public int inversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        for (int i = 1; i < nums.length; i = i*2) {
            for (int j = 0; j < nums.length + i; j += 2*i) {
                count += mergeSort(nums, j, j + i, Math.min(j + 2*i - 1, nums.length - 1));
            }
        }
        return count;
    }
    public int mergeSort(int[] nums, int leftStart, int rightStart, int rightEnd) {
        if (rightEnd < rightStart) {
            return 0;
        }
        int leftEnd = rightStart - 1;
        int length = rightEnd - leftStart + 1;

        int[] tempNums = new int[length];
        int i = length - 1;
        int count = 0;
        while (leftEnd >= leftStart && rightEnd >= rightStart) {
            if (nums[leftEnd] > nums[rightEnd]) {
                tempNums[i--] = nums[leftEnd];
                count += rightEnd - rightStart + 1;
                leftEnd--;
            }
            else {
                tempNums[i--] = nums[rightEnd];
                rightEnd--;
            }
        }
        while (leftEnd >= leftStart) {
            tempNums[i--] = nums[leftEnd--];
        }
        while (rightEnd >= rightStart) {
            tempNums[i--] = nums[rightEnd--];
        }
        for (i = 0; i < length; i++) {
            nums[leftStart++] = tempNums[i];
        }

        return count;

    }
}