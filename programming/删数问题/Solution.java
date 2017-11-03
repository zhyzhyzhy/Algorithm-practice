import java.util.Arrays;
import java.util.Scanner;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/30 - 11:11:42
*/
public class Solution{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String num = scanner.next();
		int delete = scanner.nextInt();
		int[] nums = new int[num.length()];
		int index = 0;
		for (char ch : num.toCharArray()) {
			nums[index++] = ch - '0';
		}
		for (int i = 0; i < delete; i++) {
			int j = 0;
			int before = -1;
			for (j = 0; j < nums.length; j++) {
				if(nums[j] == -1) {
					continue;
				}
				else if (before == -1) {
					before = j;
				}
				else if (nums[before] <= nums[j]) {
						before = j;
				}
				else {
					break;
				}
			}
			nums[before] = -1;
		}
		StringBuilder builder = new StringBuilder();
		for (int k : nums) {
			if (k != -1) {
				builder.append(k);
			}
		}
		System.out.println(builder.toString());
	}
}

