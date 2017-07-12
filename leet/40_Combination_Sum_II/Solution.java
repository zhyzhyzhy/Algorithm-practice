//加了剪枝条件还是很慢
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Solution {
    private List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] cut  = new int[candidates.length];
        cut[candidates.length - 1] = candidates[candidates.length - 1];
        for (int i = candidates.length - 2; i >= 0; i--) {
            cut[i] = cut[i+1] + candidates[i];
        }
        backtrace(candidates, target, 0, 0, new ArrayList<>(),cut);
        return lists;
    }
    public void backtrace(int[] candidates, int target, int i, int sum, List<Integer> list, int[] cut) {
        if (i >= candidates.length) {
            return;
        }
        if (sum + cut[i] < sum) {
            return;
        }
        backtrace(candidates, target, i + 1, sum, new ArrayList<>(list),cut);
        sum += candidates[i];
        if (sum > target) {
            return;
        }
        if (sum == target) {
            list.add(candidates[i]);
            if (!lists.contains(list)) {
                lists.add(list);
            }
            return;
        }
        list.add(candidates[i]);
        backtrace(candidates, target, i + 1, sum, new ArrayList<>(list),cut);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}