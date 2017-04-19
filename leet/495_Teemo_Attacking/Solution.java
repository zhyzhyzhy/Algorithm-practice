//思路很清晰，不说了
/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/04/18 - 19:53:40
*/
public class Solution{
	public static void main(String[] args) {
		System.out.println(findPoisonedDuration(new int[]{1,2}, 2));
	}
	public static int findPoisonedDuration(int[] timeSeries, int duration) {
		int maxTime = timeSeries.length * duration;
		int sum = 0;
		for (int i = 1; i < timeSeries.length; i++) {
			int minus = timeSeries[i] - timeSeries[i - 1];
			if (minus >= duration) {
				continue;
			} else {
				sum += duration-minus;
			}
		}
		return maxTime - sum;

    }
}

