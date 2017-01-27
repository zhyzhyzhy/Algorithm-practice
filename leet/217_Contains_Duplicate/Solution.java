import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }
    public static boolean containsDuplicate(int[] nums) {
        if(nums.length == 0)
            return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        if(set.size() == nums.length)
            return false;
        return true;
    }
}