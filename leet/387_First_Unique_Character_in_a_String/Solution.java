import java.util.HashMap;
import java.util.Map;


/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/05/29 - 11:16:15
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char var : s.toCharArray()) {
           int i = map.getOrDefault(var, 0);
           map.put(var, i+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
