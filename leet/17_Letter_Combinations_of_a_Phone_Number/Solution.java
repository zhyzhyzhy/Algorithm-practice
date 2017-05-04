import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/05/03 - 15:14:24
*/
public class Solution{
	public static void main(String[] args) {
		letterCombinations("3");
	}
	public static Map<Character,String> map = new HashMap<Character, String>() {
		{
			put('2',"abc");
			put('3',"def");
			put('4',"ghi");
			put('5',"jkl");
			put('6',"mno");
			put('7',"pqrs");
			put('8',"tuv");
			put('9',"wxyz");
		}
	};
	public static List<String> list1 = new ArrayList<String>();
	public static List<String> list2 = new ArrayList<String>();
	public static List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return list1;
		}
		for (int i = 0; i < digits.length(); i++ ) {
			list1.add(map.get(digits.charAt(i)));
		}
		getCombination(0, list1.size(), "");
		System.out.println(list2);
		return list2;
    }
	public static void getCombination(int i, int length, String x) {
		if (i == length) {
			list2.add(x);
		} 
		else {
			String a = list1.get(i);
			for (int j = 0; j < a.length(); j++) {
				String y = x + a.charAt(j);
				getCombination(i+1, length, y);
			}
		}
	}
}

