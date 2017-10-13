public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getNSumCount(3, 4));
    }
    //n个骰子，合为s出现的次数
    public int getNSumCount(int n, int s) {
        if (n == 1) {
            if (s > 0 && s <= 6) {
                return 1;
            } else {
                return 0;
            }
        }
        return getNSumCount(n - 1, s - 1) + getNSumCount(n - 1, s - 2)
        + getNSumCount(n - 1, s - 3) + getNSumCount(n - 1, s - 4)
        + getNSumCount(n - 1, s - 5) + getNSumCount(n - 1, s - 6);
    }
}