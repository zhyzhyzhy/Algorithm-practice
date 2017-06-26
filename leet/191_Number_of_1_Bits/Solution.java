/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/05/06 - 20:05:31
*/
public class Solution{
	public static void main(String[] args) {
		System.out.println(hammingWeight(11));
	}
	 // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++ ) {
			if ((n&1)  == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
    }
}

