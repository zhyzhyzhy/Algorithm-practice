import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

class Solution {
    List<List<String>> lists = new ArrayList<>();
    public List<List<String>> partition(String s) {
        char[] chs = s.toCharArray();
        recursionPartition(chs, 0, new ArrayList<>());
        return lists; 
    }
    public void recursionPartition(char[] chs, int start, List<String> list) {
        if (start == chs.length) {
            lists.add(new ArrayList<String>(list));
            return;
        }
        for (int i = start + 1; i <= chs.length; i++) {
            if(isPalindrome(chs, start, i - 1)) {
                list.add(String.copyValueOf(chs, start, i - start));
                recursionPartition(chs, i, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isPalindrome(char[] chs, int start, int end) {
        while (start < end) {
            if (chs[start] != chs[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("cbbbcc")); 
    }
}