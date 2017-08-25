public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.printNums(3);
    }

    public void printNums(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int[] num = new int[n];
        while (increase(num,n)) {
            printNum(num);
        }
    }
    public boolean increase(int[] num, int n) {
        if (n < 1) {
            return false;
        }
        if (num[n - 1] == 9) {
            num[n-1] = 0;
            return increase(num, n-1);
        }
        num[n-1] = num[n-1]+1;
        return true;
        
    }
    public void printNum(int[] num) {
        int i = 0;
        for (i = 0; i < num.length; i++) {
            if (num[i] == 0) continue;
            else {
                break;
            }
        }
        for (; i < num.length; i++) {
            System.out.print(num[i]);
        }
        System.out.println("\t");
    }
}