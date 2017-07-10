import java.util.LinkedList;
import java.util.List;


public class Solution {
    private List<List<Integer>> lists = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates, target, 0, 0, new LinkedList<>());
        return lists;
    }
    public void backtrace(int[] candidates, int target, int i, int sum, List<Integer> list) {
        if (i >= candidates.length) {
            return;
        }
        backtrace(candidates, target, i + 1, sum, new LinkedList<>(list));
        sum += candidates[i];
        if (sum > target) {
            return;
        }
        if (sum == target) {
            list.add(candidates[i]);
            lists.add(list);
            return;
        }
        list.add(candidates[i]);
        backtrace(candidates, target, i, sum, new LinkedList<>(list));
        // backtrace(candidates, target, i + 1, sum, new LinkedList<>(list));
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
