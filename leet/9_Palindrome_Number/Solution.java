//fu shu keng ding bushi
//
public class Solution {
    public static void main(String[] args) {
        isPalindrome(-2147447412);
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int fakeX = x;
        if (x >= 0 && x <= 9) {
            return true;
        }
        int length = 0;
        int y = x;
        while(y / 10 != 0) {
            length++;
            y = y / 10;
        }
        System.out.println("length = " + length);
        y = 0;
        while(length != 0) {
            int z = x % 10;
            y = z*(int)Math.pow(10,length--) + y;
            x = x / 10;
        }
        y = y + x;
        System.out.println(y);
        System.out.println(fakeX);
        if (y == fakeX) {
            return true;
        }
        return false;
    }

}