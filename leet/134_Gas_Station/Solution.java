//主要是minus数组的作用，
//假设从任意一个点i开始，然后依次开始加minus[i] ~ minus[j]里的数，如果出现负数说明这个点行不通，则从j开始
public class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
       int[] minus = new int[cost.length];
       for (int i = 0; i < minus.length; i++) {
           minus[i] = gas[i] - cost[i];
       }
       for (int i = 0; i < minus.length; i++) {
            int sum = 0;
            int j;
            for (j = i; j < minus.length + i; j++) {
                sum += minus[j % minus.length];
                if (sum < 0) {
                    if ( j > minus.length) {
                        return -1;
                    }
                    i = j;
                    break;
                }
            }
            if (j == minus.length + i) {
                return i;
            }
       }
        return -1;
    }
    public static void main(String[] args) {
       System.out.println(canCompleteCircuit(new int[]{1,2}, new int[]{2,1}));
  }
}