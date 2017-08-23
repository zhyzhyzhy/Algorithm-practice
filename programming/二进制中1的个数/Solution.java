public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.digitalOneInNum(-3));
    }
    public int digitalOneInNum(int num) {
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }
        int count = 0;
        while(num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>>= 1;
        }
        if (isNegative) {
            count++;
        }
        return count;
    }
}