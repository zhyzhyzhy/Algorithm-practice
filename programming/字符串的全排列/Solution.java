import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {


    public static List<String> calcAllPermutation(String s) {
        List<String> lists = new ArrayList<>();
        recursion(lists, s.toCharArray(), 0);
        return lists;
    }
    public static void recursion(List<String> lists, char[] chs, int i) {
        if (i == chs.length) {
            lists.add(String.valueOf(chs));
        }
        else {
            recursion(lists, chs, i+1);
            for (int j = i + 1; j < chs.length; j++) {
                char temp = chs[i];
                chs[i] = chs[j];
                chs[j] = temp;
                recursion(lists, chs, i + 1);
                temp = chs[i];
                chs[i] = chs[j];
                chs[j] = temp;
            }
        }
    }

    //字典序排列
    public static List<String> calcAllPermutation2(String s) {
        List<String> lists = new ArrayList<>();
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        lists.add(String.valueOf(chs));
        recursion2(lists, chs);
        return lists;
    }

    public static void recursion2(List<String> list, char[] chs) {
        int i;
        boolean hasFound = false;
        for (i = chs.length - 1; i >= 0; i--) {
            for (int j = chs.length - 1; j > i; j--) {
                if (chs[j] > chs[i]) {
                    char temp = chs[j];
                    chs[j] = chs[i];
                    chs[i] = temp;
                    hasFound = true;
                    break;
                }
            }
            if (hasFound) {
                break;
            }
        }
        if (i == -1) {
            return;
        }
        int j = i + 1;
        int k = chs.length - 1;
        while (j < k) {
            char temp = chs[j];
            chs[j] = chs[k];
            chs[k] = temp;
            j++;
            k--;
        }
        list.add(String.valueOf(chs));
        recursion2(list, chs);
    }
    public static void main(String[] args) {
        System.out.println(calcAllPermutation2("abcd"));
    }
}