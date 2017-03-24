public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        int length = 0;
        long y = x;
        while(y / 10 != 0) {
            length++;
            y = y / 10;
        }
        y = 0;
        while(length != 0) {
            int z = x % 10;
            y = (long)z*(int)Math.pow(10,length--) + y;
            x = x / 10;
        }
        y = y + x;
        // System.out.println(y);
        if (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)y;
    }

}