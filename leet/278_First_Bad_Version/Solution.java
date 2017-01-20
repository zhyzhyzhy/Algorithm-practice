/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/01/20 - 22:08:11
*/
//感觉就是一个简单的二分
public class Solution{
	public static void main(String[] args) {
		firstBadVersion(2);
	}
	public static boolean isBadVersion(int version) {
		if(version == 1)
			return true;
		else
			return false;
	}
	public static int firstBadVersion(int n) {
		if(n == 1)
			return 1;
		int i;
		int left = 1;
		int right = n;		
		while(left < right) {
			i = left + (right-left)/2;
			if(isBadVersion(i)) {
				right = i;
			}
			else {
				left = i + 1;
			}
		}
		return left;
	}
}

