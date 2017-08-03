import java.util.Arrays;

public class Solution {
    public static int longestPalindrome(String s) {
        char[] chs = new char[s.length() * 2 + 1];
        int max = 1;
        chs[0] = '#';
        int j = 0;
        for (int i = 1; i < chs.length; i = i + 2) {
            chs[i] = s.charAt(j++);
            chs[i+1] = '#';
        }
        System.out.println(Arrays.toString(chs));
        int[] p = new int[chs.length];
        int maxBoard = 0;
        int maxId = 0;
        int maxIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < chs.length; i++) {
            if (maxBoard > i && 2 * maxId - i >= 0) {
                p[i] = Math.min(maxBoard - i, p[2 * maxId - i]);
            } else {
                p[i] = 1;
            }
            int left = i - p[i];
            int right = i + p[i];
            while (left >= 0 && right < p.length && chs[left] == chs[right]) {
                p[i] = p[i] + 1;
                left--;
                right++;
            }
            if (p[i] + i > maxBoard) {
                maxBoard = p[i] + maxBoard;
                maxId = i;
            }
            if (p[i] > maxLength) {
                maxLength = p[i];
                maxIndex = i;
            }
        }
        System.out.println(Arrays.toString(p));
        System.out.println(maxIndex);
        if (chs[maxIndex] == '#') {
            return p[maxIndex] - 1;
        }
        return p[maxIndex] - 1;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("hellooo"));
    }
}

