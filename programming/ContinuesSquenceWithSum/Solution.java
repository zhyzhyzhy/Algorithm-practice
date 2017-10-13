import java.util.List;
import java.util.ArrayList;
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.continuesSquenceWithSum(15));
    }
    public List<List<Integer>> continuesSquenceWithSum(int target) {
        int start = 1;
        int end = 2;
        List<List<Integer>> lists = new ArrayList<>();
        int sum = 3;
        while (start < end && end <= target / 2 + 1) {
            System.out.println(start + "  " + end + "  " + sum);
            if (sum < target) {
                end++;
                sum += end;
            }
            else if (sum > target) {
                sum -= start;
                start++;
            }
            else {
                List<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                lists.add(list);
                sum -= start;
                start++;
            }
        }
        return lists;
    }
}