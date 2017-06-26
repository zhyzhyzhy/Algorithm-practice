/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/05/29 - 11:02:27
*/
public class Solution{
	public static void main(String[] args) {

	}
	public String reverseString(String s) {
		if (s.length() == 0) {
			return s;
		}
		StringBuilder builder = new StringBuilder();
		int i = s.length() - 1;
		while (i >= 0) {
			builder.append(s.charAt(i));
			i--;
		}
		return builder.toString();
    }
}

