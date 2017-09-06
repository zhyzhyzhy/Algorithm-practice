import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxProduct(String[] words) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                boolean isBreak = false;
                for (char c : words[i].toCharArray()) {
                    set.add(c);
                }
                for (char c : words[j].toCharArray()) {
                    if (set.contains(c)) {
                        isBreak = true;
                        break;
                    }
                }
                if (!isBreak) {
                    max = max > words[i].length() * words[j].length() ? max:words[i].length() * words[j].length();
                }
                set.clear();
            }
        }
        return max;
    }
    public int maxProduct1(String[] words) {
        int[] values = new int[words.length];
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                values[i] |= 1 << (words[i].charAt(j) - '0');
            }
        }
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if ((values[i] & values[j]) == 0) {
                    max = max > words[i].length() * words[j].length() ? max:words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println('a'^'b');
    }
}