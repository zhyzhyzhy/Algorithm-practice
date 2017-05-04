import java.util.Arrays;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/05/01 - 12:43:33
*/
public class Solution{
	public static void main(String[] args) {
		System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4}));
	}

    public static int numberOfArithmeticSlices(int[] A) {
		if (A.length < 2) {
			return 0;
		}
		int[] arr = new int[A.length - 1];
		for (int i = 1; i < A.length ; i++) {
			arr[i-1] = A[i] - A[i-1];
		}
		System.out.println(Arrays.toString(arr));
		int count = 0;
		int max = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i-1]) {
				max++;
			}
			else {
				count += max*(max-1)/2;
				max = 1;
			}
		}
		count += max*(max-1)/2;
		return count;
    }

}

