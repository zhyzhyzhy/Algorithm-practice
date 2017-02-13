import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/02/13 - 20:06:23
*/
public class Solution{
	public static void main(String[] args) {
		List<String> list = summaryRanges(new int[]{0,2});
		Iterator<String>  demo = list.iterator();
		while(demo.hasNext()) 
			System.out.println(demo.next());
	}
	public static  List<String> summaryRanges(int[] nums) {
		if (nums == null) {
			return null;
		}
		List<String> list = new LinkedList<>();
		if (nums.length == 0)
			return list;
		int start = 0;
		int i;
		for (i = 0 ; i < nums.length -1; i++ ) {
			if ( nums[i] + 1 != nums[i+1] ) {
				if (start != i) {
					list.add(nums[start] + "->" +nums[i]);
				}
				else {
					list.add(nums[start] + "");
				}
				start = i+1 ;
			}
		}
		if (start != i) {
			list.add(nums[start] + "->" +nums[i]);
		}
		else {
			list.add(nums[start] + "");
		}
		return list;
    }
}

