//输入n，输出第n项的值
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(4));
    }

    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n <= 2) {
            return 1;
        }
        int i = 1;
        int j = 1;
        int result = 2;
        for (int k = 2; k < n; k++) {
            result = i + j;
            i = j;
            j = result;
        }
        return result;
    }
}