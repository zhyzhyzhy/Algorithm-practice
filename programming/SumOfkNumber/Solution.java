import java.util.ArrayList;
import java.util.List;

//输入两个整数n和sum，从数列1，2，3.......n 中随意取几个数，使其和等于sum，要求将其中所有的可能组合列出来。
public class Solution {

    //转化成01背包
    public List<List<Integer>> sumOfkNumber(int sum, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        recursionSumOfKumber(lists, new ArrayList<>(), sum, n);
        return lists;
    }
    private void recursionSumOfKumber(List<List<Integer>> lists, List<Integer> list, int sum, int n) {
        if (sum <= 0 || n <= 0) {
            return;
        }
        if (sum == n) {
            list.add(n);
            lists.add(new ArrayList(list));
            list.remove(list.size() - 1);
        }
        else {
            list.add(n);
            recursionSumOfKumber(lists, list, sum - n, n - 1);
            list.remove(list.size() - 1);
        }
        recursionSumOfKumber(lists, list, sum, n - 1);
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfkNumber(10, 100));
    }
}