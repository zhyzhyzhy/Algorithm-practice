import java.util.*;
public class Solution {
    public static void main(String[] args) {
        System.out.println(findTheDifference("", "helleo"));
    }
    public static char findTheDifference(String s, String t) {
        char[] x = s.toCharArray();
        char[] y = t.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        int i;
        for(i = 0; i < x.length; i++) {
            if(x[i] != y[i])
                return y[i];
        }
        return y[i];
    }
}