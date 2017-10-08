import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getUglyNumber(1500));
    }
    public int getUglyNumber(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException();
        }
        int[] nums = new int[index + 1];
        nums[0] = 1;
        int mul2Index = 0;
        int mul3Index = 0;
        int mul5Index = 0;
        int currentIndex = 1;
        while (currentIndex < index) {
            int min = Math.min(nums[mul2Index]*2, nums[mul3Index]*3);
            min = Math.min(min, nums[mul5Index]*5);
            nums[currentIndex] = min;
            while (nums[mul2Index]*2 <= nums[currentIndex]) {
                mul2Index++;
            }
            while (nums[mul3Index]*3 <= nums[currentIndex]) {
                mul3Index++;
            }
            while (nums[mul5Index]*5 <= nums[currentIndex]) {
                mul5Index++;
            }
            currentIndex++;
        }
        System.out.println(Arrays.toString(nums));
        return nums[index-1];

    }
}