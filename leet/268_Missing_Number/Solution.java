/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/01/19 - 22:27:10
*/
public class Solution{
	public static void main(String[] args) {
		System.out.println(Double.parseDouble("."));
	}
	//解法1，加起来，然后相减就得出
//    public static int missingNumber(int[] nums) {
//	    int temp = 0;
//	    int total = 0;
//	    for(int i = 0; i < nums.length; i++) {
//	        total += nums[i];
//	        temp += i;
//		}
//		return temp - total + nums.length;
//	}
	//解法2，运用异或
	//(a^b)^a = b 推广至很多数
	//也就是a^a = 0
	//0^a = a
	//成对出现的数都相互抵消了
    public static int missingNumber(int[] nums) {
		int x = 0;
		for(int i = 0; i < nums.length+1; i++)
			x ^= i;
		for (int i : nums) {
			x ^= i;
		}
		return x;
	}

}

