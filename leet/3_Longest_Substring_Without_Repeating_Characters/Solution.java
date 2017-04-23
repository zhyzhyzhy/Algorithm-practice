//两个指针一个Set
import java.util.HashSet;
import java.util.Set;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/04/23 - 18:56:18
*/
public class Solution{
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return s.length();
		}
		Set set = new HashSet();
		int i = 0;
		int j = 1;
		int maxLength = 1;
		int length= 1;
		set.add(s.charAt(i));
		while(j < s.length()) {
			if (set.add(s.charAt(j)) == false) {
				while(s.charAt(i) != s.charAt(j)) {
					set.remove(s.charAt(i));
					i++;
					length--;
				}
				set.remove(s.charAt(i));
				i++;
				set.add(s.charAt(j));
			} else {
				set.add(s.charAt(j));
				length++;
				if (length > maxLength ) {
					maxLength = length;
				}
			}
			j++;
		}

		return maxLength;
    }
}

