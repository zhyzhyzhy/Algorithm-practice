import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<String> list = new LinkedList<>();
    public List<String> readBinaryWatch(int num) {
       backtrace(0, 0, 0, num);
       return list;
    }
    void backtrace(int hour, int minute, int start, int num) {
        if (num == 0) {
            if (hour < 12 && minute < 60) {
                list.add(String.format("%d:%02d", hour, minute));
            }
            return;
        }
        int hour1 = 0;
        int minute1 = 0;
        if (start < 4) {
            hour1 += Math.pow(2, start);
        }
        else {
            minute1 += Math.pow(2, 9 - start);
        }
        if (10 - start == num) {
            backtrace(hour + hour1, minute + minute1, start + 1, num - 1); 
        }
        else {
            backtrace(hour, minute, start + 1, num);
            backtrace(hour + hour1, minute + minute1, start + 1, num - 1); 
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.readBinaryWatch(1)); 
    }
}