public class Solution {
	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length())
			return false;
		int[] charTable = new int[26];
		for(int i = 0; i < s.length(); i++) {
			charTable[s.charAt(i) - 'a']++;
		}
		for(int i = 0; i < t.length(); i++) {
			charTable[s.charAt(i) - 'a']--;
		}
		for(int count : charTable)
			if(count != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		String a = "abc";
		String b = "bca";
		System.out.println(isAnagram(a,b));
	}
}