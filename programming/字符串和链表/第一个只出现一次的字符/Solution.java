import java.util.HashMap;
import java.util.Map;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/08/13 - 11:02:39
*/
public class Solution{
	public static void main(String[] args) {

	}
	public char firstCharOnlyShowOnce(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : str.toCharArray()) {
			int count = map.getOrDefault(c, 0);
			map.put(c, count + 1);
		}
		for (char c : str.toCharArray()) {
			if (map.get(c) == 1) {
				return c;
			}
		}
		return 0;
	}
}

