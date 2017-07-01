public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxlength = 1;
        int tail = nums.length;
        for (int i = 1; i < tail; i++) {
            if (nums[i] == nums[i-1]) {
                int j = i + 1;
                int index = i;
                while (j < tail && nums[j] == nums[i]) {
                    j++;
                }
                while (j < tail) {
                    nums[index++] = nums[j++];
                }
                tail = index;
                i--;
            }
        }        
        return tail;
    }
}