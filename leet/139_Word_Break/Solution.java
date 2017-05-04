//算是个dfs，列出所有的可能，主要是那些细节的处理挺有意思的
import java.util.LinkedList;
import java.util.List;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/05/02 - 18:44:50
*/
public class Solution{
	public static void main(String[] args) {
		System.out.println(wordBreak("leetcode", new LinkedList<String>(){{
			add("leet");
			add("code");
		}}));
	}
	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length() ; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] == true && wordDict.contains(s.substring(j,i))) {
					dp[i] = true;
				}
			}
		}
		return dp[s.length()];
    }
}

