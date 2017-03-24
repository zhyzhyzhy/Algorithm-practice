import java.math.BigInteger;
public class Solution {
    // public static int[] plusOne(int[] digits) {
    //     String number= "";
    //     for(int i = 0; i < digits.length; i++)
    //         number = number+digits[i];
    //     BigInteger NumbertoInt = new BigInteger(number);
    //     NumbertoInt = NumbertoInt.add(new BigInteger("1"));
    //     number = ""+NumbertoInt;
    //     int[] result = new int[number.length()];
    //     for(int i = 0; i < result.length; i++) {
    //         result[i] = number.charAt(i)-48;
    //     }
    //     return result;
    // }

    public static int[] plusOne(int[] digits) {
        if(digits[digits.length-1] != 9) {
            digits[digits.length-1]++;
            return digits;
        }
        else {
            int i = digits.length - 1;
            while(i >= 0 && digits[i] == 9) {
                digits[i] = 0;
                i--;
            }
            if(i == -1) {
                int[] Result = new int[digits.length+1];
                Result[0] = 1;
                for(int j = 1; j < Result.length; j++) {
                    Result[j] = digits[j-1];
                }
                return Result;
            }
            else {
                digits[i]++;
                return digits;
            }
        }
    }
    public static void main(String[] args) {
        int[] test = new int[]{9,9,9};
        int[] get;
        get = plusOne(test);
        for(int i = 0; i < get.length; i++)
            System.out.print(get[i]);
    }
}