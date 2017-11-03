/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/30 - 15:51:06
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 || nums.length == 2) {
            return nums.length;
        }
        int[] newNums = new int[nums.length];
        int index = 0;
        int count = 0;
        int i = 0;
        int before = -2222;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == before) {
                continue;
            }
            else if (i + 2 < nums.length && nums[i] == nums[i+2]) {
                i = i + 1;
                count += 2;
                newNums[index++] = nums[i];
                newNums[index++] = nums[i];
                before = nums[i];
            }
            else {
                newNums[index++] = nums[i];
                count++;
            }
        }
        System.arraycopy(newNums, 0, nums, 0, count);
        return count;
    }
	//自己写的很复杂，看讨论有个更简单的
	public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i < 2 || n > nums[i-2])
            nums[i++] = n;
    return i;
	}
}
