import java.util.Arrays;
import java.util.Set;
import java.util.Iterator;
import java.util.TreeSet;

public class Solution {
//    public static String longestPalindrome(String s) {
//        if (s.length() == 0 || s.length() == 1) {
//            return s;
//        }
//		if (s.length() == 2) {
//			if (s.charAt(0) == s.charAt(1)) {
//				return s;
//			}
//			else {
//				return s.substring(0,1);
//			}
//		}
//        String maxString = "";
//        for (int i = 1; i < s.length() - 1; i++) {
//            int j = i-1;
//            int k = i+1;
//            int max = 1;
//            while (j >= 0 && s.charAt(j) == s.charAt(i)) {
//				j--;
//				max++;
//            }
//            while (k <= s.length() - 1 && s.charAt(k) == s.charAt(i)) {
//                k++;
//				max++;
//            }
//			if (j == -1 || k == s.length()) {
//				if (max > maxString.length() ) {
//					maxString = s.substring(j+1, k);
//				}
//				continue;
//			}
//			boolean flag = false;
//            while(j >= 0 && k < s.length()) {
//                if (s.charAt(j--) == s.charAt(k++)) {
//                    max += 2;
//                }
//                else {
//					flag = true;
//                    break;
//                }
//            }
//			if (max > maxString.length()) {
//				if (flag == true) {
//					maxString = s.substring(j+2, k-1);
//				}
//				else {
//					maxString = s.substring(j+1, k);
//				}
//			}
//		}
//        return maxString;
//    }
    public static String longestPalindrome(String s) { 
		char[] str = new char[s.length()*2 + 2];
		str[0] = '$';
		str[1] = '#';
		for (int i = 0; i < s.length(); i++) {
			str[i*2 + 2] = s.charAt(i);
			str[i*2 + 3] = '#';
		}
		int[] p = new int[str.length+1];
		int mx = 0;
		int id = 0;
		for (int i = 1; i < str.length; i++) {
			if(mx > i) {
				p[i] = (p[2*id - i] < (mx - i) ? p[2*id - i] : (mx - i));
			}
			else {
				p[i] = 1;
			}
			while(i+p[i] < str.length && str[i-p[i]] == str[i+p[i]])
				p[i]++;

			if(i + p[i] > mx) {
				mx = i + p[i];
				id = i;
			}
		}
		//System.out.println(Arrays.toString(p));
		//System.out.println(Arrays.toString(str));
		int max = 0;
		int position = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i] > max) {
				max = p[i];
				position = i;
			}
		}
		//System.out.println("position = " + position );
		max = (max - 2) / 2;
		if (str[position] == '#') {
			position = (position - 3) / 2;
			return s.substring(position - max, position + max + 2);
		}
		else {
			position = (position - 2) / 2;
			return s.substring(position - max, position + max + 1);
		}
	}
    public static void main(String[] args) {
       System.out.println(longestPalindrome("abcba")); 
    }
}
