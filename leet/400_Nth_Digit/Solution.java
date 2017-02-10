/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/02/09 - 13:41:15
*/
public class Solution{
	public static void main(String[] args) {
        System.out.println(findNthDigit(2));
	}
    public static int findNthDigit(int n) {
        String x = "";
        int i = 1;
        while(x.length() < n) {
            x = x + String.valueOf(i++);
        }
        return x.charAt(n-1)-'0';
    }
}

