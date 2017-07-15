import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('[');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String frage = "";
                while (stack.peek() != '[') {
                    frage = stack.pop() + frage;
                }
                stack.pop();
                String size = "";
                while (Character.isDigit(stack.peek())) {
                    size = stack.pop() + size;
                }
                int length = Integer.parseInt(size);
                String fullFrage = "";
                for (int j = 0; j < length; j++) {
                    fullFrage += frage;
                }
                for (char ch : fullFrage.toCharArray()) {
                    stack.push(ch);
                }
            }
            else {
                stack.push(s.charAt(i));
            }
        } 
        StringBuilder builder = new StringBuilder();
        for (Object ch : stack.toArray()) {
            builder.append((char)ch);
        } 
        return builder.substring(1);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("2[2[b]]")); 
    }
}