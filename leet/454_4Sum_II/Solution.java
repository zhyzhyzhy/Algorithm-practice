import java.util.HashMap;
import java.util.Map;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/02/14 - 19:07:24
*/
public class Solution{
	public static void main(String[] args) {

	}
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int total = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length ; i++ ) {
			for (int j = 0; j < B.length; j++ ) {
				int sum = A[i] + B[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		for (int i = 0; i < C.length ; i++ ) {
			for (int j = 0; j < D.length; j++ ) {
				int sum = C[i] + D[j];
				total += map.getOrDefault(-1*sum, 0);
			}
		}
		return total;
    }
}

