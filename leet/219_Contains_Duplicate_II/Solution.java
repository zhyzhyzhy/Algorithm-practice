import java.util.Arrays;

import com.sun.org.apache.regexp.internal.recompile;


public class Solution {
    public static boolean containsNeabDuplicate(int[]nums,int k){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
}
public static void main(String[]args){

}
}