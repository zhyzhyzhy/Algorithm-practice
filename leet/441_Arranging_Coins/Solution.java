public class Solution {
	public static void main(String[] args) {
		System.out.println(arrangeCoins(2147483647));
	}
	public static int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}
