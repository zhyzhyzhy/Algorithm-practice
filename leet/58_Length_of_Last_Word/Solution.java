public class Solution {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("hello world "));
	}
    public static int lengthOfLastWord(String s) {
    	int i = s.length() -1;
    	if( s == null || s.equals(""))
    		return 0;
    	while(i >= 0 && s.charAt(i) == ' ')
    		i--;
    	int count = 0;
    	while(i >= 0 && s.charAt(i) != ' ' ) {
    		count++;
    		i--;
    	}
    	return count;
    }
}