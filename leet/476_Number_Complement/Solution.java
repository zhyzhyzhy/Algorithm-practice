public class Solution {
    public static int findComplement(int num) {
        int count = 1;
        int x = num;
        while(x/2 != 0) {
            count++;
            x = x/2;
        }
        return (~num << (32-count)) >>> (32 - count);        
    }
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}