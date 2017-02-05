import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    //一个很蠢的方法了，但是实在想不出
  public static List<Integer> findDuplicates(int[] nums) {
      if(nums == null)
        return null;
      Set<Integer> set = new HashSet<>();
      List<Integer> list = new ArrayList<Integer>();
      for(int i = 0; i < nums.length; i++) {
          if(set.add(nums[i]) == false)
           list.add(nums[i]); 
      }
      return list;
  }
  //discussion里看到的，只能说太机智了。用数字所为索引，把索引处的数字反过来，如果发现那个数字已经反过来了，就说明有重复的数了。。。
  public List<Integer> findDuplicates(int[] nums) {
     List<Integer> result = new ArrayList<Integer>();
    if(nums == null)
        return result;
    for(int i=0; i<nums.length; i++){
        int location = Math.abs(nums[i])-1;
        if(nums[location] < 0){
            result.add(Math.abs(nums[i]));
        }else{
            nums[location] = -nums[location];
        }
    }
    for(int i=0; i<nums.length; i++)
        nums[i] = Math.abs(nums[i]);
   
    return result;
}
  public static void main(String[] args) {
      System.out.println(new int[]{4,3,2,7,8,3,2,1});
  }
}