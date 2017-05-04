//竟然打败了百分之95的人。。。可怕
import java.util.ArrayList;
import java.util.List;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/05/04 - 20:59:43
*/
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.subsets(new int[]{1,2,3});
	}

	List<List<Integer>> list = new ArrayList<>();
	public List<List<Integer>> subsets(int[] nums) {
		if (nums.length == 0) {
			return list;
		}
		else {
			getSubSets(new ArrayList<Integer>(), 0, nums);
			System.out.println(list);
		}
		list.add(new ArrayList<Integer>());
		return list;
    }
	public void getSubSets(List<Integer> list1, int i , int[] nums) {
		if (i == nums.length) {
			return;
		} 
		else {
			List<Integer> list2 = new ArrayList<Integer>(list1);
			list2.add(nums[i]);
			list.add(list2);
			//System.out.println(list2);
			getSubSets(list1, i+1, nums);
			getSubSets(list2, i+1, nums);
		}
	}
}

