import java.util.LinkedList;
import java.util.List;

public class Solution {

    private List<String> list = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        backtrace("", 0, 0, n); 
        return list;
    }
    public void backtrace(String str, int open, int close, int n) {
        if (close == n) {
            list.add(str);
            return;
        }
        if (open < n) {
            backtrace(str+"(", open + 1, close, n);
        }
        if (close < open ) {
            backtrace(str+")", open, close+1, n);
        }
    }
    public static void main(String[] args) {
       Solution solution = new Solution();
       System.out.println(solution.generateParenthesis(4)); 
    }
}