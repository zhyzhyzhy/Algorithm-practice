/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/11/03 - 11:26:38
*/
class Solution {
    
    private List<List<Integer>> lists = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recursionSub(nums, new ArrayList<Integer>(), 0);
        return lists;
        
    }
    public void recursionSub(int[] nums, List<Integer> list, int start) {
        if (start >= nums.length) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        int num = nums[start];
        int i = 0;
        for (i = start + 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            else {
                break;
            }
        }       
        //当前数加0到n个进去
        for (int j = 0; j <= i - start; j++) {
            for (int k = 0; k < j; k++) {
                list.add(nums[start]);
            }
            recursionSub(nums, list, i);
            for (int k = 0; k < j; k++) {
                list.remove(list.size() - 1);
            }
        }
    } 
}
