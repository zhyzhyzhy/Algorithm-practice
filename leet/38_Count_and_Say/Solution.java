/**
 * Created by Administrator on 2017/3/23.
 */
public class Solution {
    public String countAndSay(int n) {
        String before = "1";
        String next = "";
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < before.length(); j++) {
                int count = 1;
                while (j != before.length() - 1 && before.charAt(j) == before.charAt(j + 1)) {
                    count++;
                    j++;
                }
                next = next + count + (before.charAt(j) - 48);
//                System.out.println(next);
            }
            before = next;
            next = "";
        }
        return before;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(4));
    }
}