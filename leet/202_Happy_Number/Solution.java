import java.util.HashSet;
import java.util.LinkedHashSet;
public class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        HashSet<Integer> set = new LinkedHashSet<>();        
        while (sum != 1) {
            sum = 0;
            while (n != 0) {
                sum += Math.pow(n%10, 2);
                n = n/10;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
        return true;
    }
    public static void main(String[] args) {
       Solution solution = new Solution();
       System.out.println(solution.isHappy(3)); 
    }

}