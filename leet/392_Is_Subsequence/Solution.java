/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/04/20 - 17:12:17
*/
public class Solution{
	public static void main(String[] args) {

	}
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0) {
			return true;
		}
		int i = 0;
		int j = 0;
		while(j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
				if (i == s.length()) {
					return true;
				}
			}
			else {
				j++;
			}
		}
		return false;
	}
}

