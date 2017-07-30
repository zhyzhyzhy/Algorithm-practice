
public class Solution {
    public int minSteps(int n) {
        return recursion(n);
    }
    public int recursion(int n) {
        if (n <=  1) {
            return 0;
        }
        int half = n / 2;
        while (n % half != 0) {
            half--;
        }
        return n / half + recursion(half);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps(9)); 
    }
}