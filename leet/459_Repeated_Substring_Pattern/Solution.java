/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/02/09 - 18:23:10
*/
//
//
//太慢了妈蛋
public class Solution{
	public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
	}
    public static boolean repeatedSubstringPattern(String str) {
        int length = 1;
        String sub = str.substring(0,length++);
        int i = 0;
        while(sub.length() < str.length()) {
            i = length - 1;
            int j = 0;
            while(i < str.length()) {
                if(str.charAt(i) == sub.charAt(j++%(length-1))) {
                    i++;
                }
                else {
                    break;
                }
            }
            if(i == str.length() && j % (length-1) ==  0)
                return true;
            sub = str.substring(0,length++);
        }
        return false;
    }
}

