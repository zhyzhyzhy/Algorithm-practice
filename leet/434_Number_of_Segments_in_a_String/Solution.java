/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/02/10 - 15:24:05
*/
public class Solution {
	public static void main(String[] args) {
        System.out.println(countSegments("hello, i am awesome! hah a"));
	}
    public static int countSegments(String s) {
        int count = 1;
        s = s.trim();
        if (s.equals(""))
            return 0;
        for (int i = 0; i < s.length(); i++ ) {
            if(s.charAt(i) == ' ') {
                while(s.charAt(i) == s.charAt(i+1))
                    i++;
                count++;
            }
        }
        return count;
    }
}

