public class Solution {
    public boolean judgeSquareSum(int c) {
        int right = (int)Math.sqrt(c);
        int left = 0;
        while (left <= right) {
            int sum = left * left + right * right;
            if (c == sum) {
                return  true;
            }
            else if (c > sum) {
                left++;
            }
            else {
                right--;
            }
        }        
        return false;
    }
}