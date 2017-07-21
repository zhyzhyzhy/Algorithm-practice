public class Solution {
    public int singleNumber(int[] nums) {
        int i = 0;
        for (int num : nums) {
            i ^= num;
        }
        return i;
    }
    public static void main(String[] args) {
       Solution solution = new Solution();
       System.out.println(solution.singleNumber(new int[]{1,2,2})); 
    }
}
