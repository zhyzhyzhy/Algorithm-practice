import java.util.Arrays;
import java.util.Comparator;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/01 - 21:20:04
*/
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.minNumber(new int[]{3,32,321});
	}
	public String minNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			throw new IllegalArgumentException();
		}
		System.out.println(Arrays.toString(nums));
		qsort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
		return null;
	}
	public void qsort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		int tempValue = nums[left];
		int l = left;
		int r = right;
		while (l < r) {
			while (l < r && compare(nums[r], tempValue) <= 0) {
				r--;
			}
			if (l < r) {
				nums[l] = nums[r];
				l++;
			}
			while (l < r && compare(nums[l], tempValue) > 0) {
				l++;
			}
			if (l < r) {
				nums[r] = nums[l];
				r--;
			}
		}
		nums[r] = tempValue;
		qsort(nums, left, l - 1);
		qsort(nums, r + 1, right);
	}
	public int compare(int x, int y) {
		String s1 = String.valueOf(x);
		String s2 = String.valueOf(y);
		for (int i = 0; i < s1.length() && i < s2.length(); i++) {
			int cmp = s1.charAt(i) - s2.charAt(i);
			if (cmp < 0) {
				return -1;
			}
			else if (cmp > 0) {
				return 1;
			}
		}
		return s1.length() - s2.length();
	}
}

