import java.util.LinkedList;
public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                list.push(s.charAt(i));
                continue;
            }
            if (list.size() == 0) {
                return false;
            }
            if (s.charAt(i) == ')') {
                if (list.pop() != '(') {
                    return false;
                }
            }
            else if (s.charAt(i) == ']') {
                if (list.pop() != '[') {
                    return false;
                }
            }
            else if (s.charAt(i) == '}') {
                if (list.pop() != '{') {
                    return false;
                }
            }
        }        
        if (list.size() == 0) 
            return true;
        else 
            return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("([)]"));
    }
}