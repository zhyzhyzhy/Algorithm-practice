public class Solution {
    public static void main(String[] args) {
        String[] strs = new String[]{""};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return null;
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int maxLength = strs[0].length();
        for (String str : strs) {
            if (maxLength > str.length())
                maxLength = str.length();
        }
//        System.out.println(maxLength + "   cdvfd");
        int i = 0;
        while(i < maxLength) {
            boolean flag = false;
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j+1].charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
            i++;
        }
//        System.out.println(i + " cdscdscsd");
        return strs[0].substring(0,i);
    }
}