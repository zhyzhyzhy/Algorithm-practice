import java.util.*;
public class Solution {
    public static String largestNumber(int[] nums) {
    	final String[] strings = new String[nums.length];
    	for (int i = 0; i < nums.length; i++ ) {
    		strings[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String s, String t1) {
			  String x = s + t1;
			  String y = t1 + s;
			  for(int i = 0; i < x.length(); i++) {
			  	if(x.charAt(i) > y.charAt(i))
			  		return -1;
			  	else if(x.charAt(i) < y.charAt(i))
			  		return 1;
			  }
			  return 0;
			}

			@Override
			public boolean equals(Object o) {
				return false;
			}
		});
        String result = "";
        for (int i = 0; i < strings.length; i++) {
        	result = result+strings[i];
		}
		if(result.charAt(0) == '0')
			return "0";
    	return result;
    }
    public static void main(String[] args) {
    	int[] test = new int[3];
    	test[0] = 32;
    	test[1] = 1;
    	test[2] = 0;
    	System.out.println(largestNumber(test));
    }
}