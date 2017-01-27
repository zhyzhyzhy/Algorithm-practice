import java.util.*;
public class Solution {
	public static void sortColors1(int[] nums) {
		int i = 0;
		int j = 0; 
		int k = 0;
		for(int n: nums) {
			switch(n) {
				case 0:
					i++; break;
				case 1:
					j++; break;
				case 2:
					k++; break;
			}
		}
		for(int m = 0; m < i; m++)
			nums[m] = 0;
		for(int m = i; m < i+j; m++)
			nums[m] = 1;
		for(int m = i+j; m < i+j+k; m++)
			nums[m] = 2;
	}
	public static void sortColors2(int[] nums) {
		int N = nums.length;
		int h = 1;
		while(h < N/3)
			h = 3*h + 1;
		while(h>=1) {
			for(int i = h; i < nums.length; i++) {
				int temp = nums[i];
				int j = i;
				while(j >= h && nums[j - h] > temp) {
					nums[j] = nums[j - h];
					j = j -h;
				}
				nums[j] = temp;
			}

			h = h /3;
		}
	}
	public static void main(String[] args) {
		int[] test = new int[]{1,0};
		sortColors2(test);
		System.out.println(Arrays.toString(test));
	}
}