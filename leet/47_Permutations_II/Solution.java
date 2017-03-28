import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        Arrays.sort(nums);
        permute(lists, nums, 0, nums.length - 1);
        return lists;
    }
    public void permute(List list, int[] nums, int i, int j) {
        int[] newNums = nums.clone();
        if (i < j) {
            permute(list, newNums, i + 1, j);
            for (int k = i + 1; k <= j; k++) {
                if (newNums[k] == newNums[i]) {
                    continue;
                }
                else {
                    swap(newNums, k, i);
                    permute(list, newNums, i + 1, j);
                }
            }
        }
        else {
            List<Integer> list1 = new LinkedList<>();
            for (int m : newNums) {
                System.out.print(m + " ");
                list1.add(m);
            }
            System.out.println();
            list.add(list1);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permuteUnique(new int[]{1,1,3,1});
    }
}