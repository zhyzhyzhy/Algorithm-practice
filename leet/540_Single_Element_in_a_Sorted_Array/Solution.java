public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNonDuplicate(new int[]{1,1,2,2,3,3,4}));        
    }
    public int singleNonDuplicate(int[] nums) {
        // int i = 0;
        // for (int num : nums) {
            // i = i ^ num;
        // }
        // return i;
        int left = 0;
        int right = nums.length / 2;
        while (left < right) {
           int mid = left + (right - left)/2; 
            System.out.println("left:" + left + " right:" + right + " mid: " + mid);
            if (nums[mid * 2] == nums[mid * 2 + 1]) {
               left = mid+1;
           }
           else {
               right = mid;
           }
        }
        return nums[left * 2];
    }
}