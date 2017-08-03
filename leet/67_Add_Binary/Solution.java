import java.util.Stack;
public class Solution {
    public String addBinary(String a, String b) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int aLength = a.length();
        int bLength = b.length();
        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; i++) {
                stack2.push('0');
            }
        }
        else {
            for (int i = 0; i < bLength - aLength; i++) {
                stack1.push('0');
            }

        }
        stack2.push('0');
        stack1.push('0');
        for (char ch : a.toCharArray()) {
            stack1.push(ch);
        }
        for (char ch : b.toCharArray()) {
            stack2.push(ch);
        }

        boolean isCarry = false;
        StringBuilder builder = new StringBuilder();
        while (stack1.size() > 0 && stack2.size() > 0) {
            char temp = (char)(stack1.pop() + stack2.pop() - '0');
            if (isCarry) {
                temp += 1;
            }
            if (temp > '1') {
                isCarry = true;
                temp -= 2;
            }
            else {
                isCarry = false;
            }
            builder.insert(0, temp);
        }
        String result = builder.toString();
        if (result.startsWith("0")) {
            return result.substring(1);
        }
        return result;

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }
}