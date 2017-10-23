/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/23 - 19:28:29
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length - 1;
        for (int i = length; i >= 0; i--) {
            for (int j = length; j > i; j--) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    for (int k = length; k > i; k--) {
                        for (int m = length; m > k; m--) {
                            if (nums[k] < nums[m]) {
                                temp = nums[k];
                                nums[k] = nums[m];
                                nums[m] = temp;
                                return;
                            }
                        }
                    }
                    int left = i + 1;
                    int right = length;
                    while (left < right) {
                        temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                        left++;
                        right--;
                    }
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}
