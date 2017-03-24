public class Solution {
    public static void main(String[] args) {

    }
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (i + j == haystack.length()) {
                    return -1;
                }
                else if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                else if(j == needle.length() - 1) {
                    return i;
                }
            }
        }   
        return -1;
    }
}
