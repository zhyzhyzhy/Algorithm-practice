import java.util.*;
public class Solution {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{1,2,3,4,4,9,56,90}, 8)));
	}
	public static int[] twoSum(int[] numbers, int target) {
		int left;
		int right;
		int j;
		for (int i = 0; i < numbers.length; i++) {
			left = i + 1;
			right = numbers.length - 1;
			while(left <= right) {
				j = left + (right - left)/2;
				int cmp = numbers[j] + numbers[i] - target;
				if(cmp > 0) {
					right = j - 1;
				}
				else if(cmp < 0) {
					left = j + 1;
				}
				else {
					return new int[]{i+1,j+1};
				}
			}
		}
		return null;
    }
}