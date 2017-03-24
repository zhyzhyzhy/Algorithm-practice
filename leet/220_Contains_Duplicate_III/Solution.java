public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || t < 0 || k < 1)
            return false;
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            Long floor = treeSet.floor((long)nums[i] + t);
            Long ceil  = treeSet.ceiling((long)nums[i] - t);
            if((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i]))
                return true;
            treeSet.add((long)nums[i]);
            if(i >= k)
                treeSet.remove((long)nums[i - k]);
        }
        return false;
    }
}