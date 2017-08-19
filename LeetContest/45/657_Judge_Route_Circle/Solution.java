/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/08/13 - 10:45:31
*/
public class Solution{
	public static void main(String[] args) {

	}
	public boolean judgeCircle(String moves) {
		int[] counts = new int[2];
		for (char c : moves.toCharArray()) {
			switch(c) {
				case 'U': counts[0]++;break;
				case 'D': counts[0]--;break;
				case 'L': counts[1]++;break;
				case 'R': counts[1]--;break;
			}
		}
		if (counts[0] == 0 && counts[1] == 0) {
			return true;
		}
		return false;
	}
}

