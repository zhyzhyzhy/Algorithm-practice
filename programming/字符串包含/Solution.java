/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/07/20 - 12:46:42
*/
/*给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
 * 用位向量
*/
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.StringContain("hello", "lloep"));
	}
	boolean StringContain(String a,String b) {
		int hash = 0;
		for (int i = 0; i < a.length(); i++) {
			hash |= 1 << ( a.charAt(i) - 'a');
		}
		for ( int i = 0; i < b.length(); i++) {
			if( (hash & 1 << (b.charAt(i) - 'a')) == 0) {
				return false;
			}
		}
		return true;
	}
}

