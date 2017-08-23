public class Solution {

    //考虑边界情况,如果是负数，0
    public double power(double num, int times) {
        if (equals(num, 0.0) && times == 0) {
            throw new IllegalArgumentException();
        } 
        if (equals(num, 0.0)) {
            return 0;
        }
        boolean isNegative = false;
        if (times < 0) {
            isNegative = true;
            times = -times;
        }

        double result = 1.0;
        for (int i = 0; i < times; i++) {
            result *= num;
        }
        


        if (isNegative) {
            result = 1.0 / result;
        }

        return result;
    }

    public double power2(double num, int times) {
        if (equals(num, 0.0) && times == 0) {
            throw new IllegalArgumentException();
        } 
        if (equals(num, 0.0)) {
            return 0;
        }
        boolean isNegative = false;
        if (times < 0) {
            isNegative = true;
            times = -times;
        }

        double result = 1.0;
        if (times % 2 == 1) {
            result = num;
            times--;
        }

        while (times / 2 != 0) {
            result *= result;
            times >>= 1;
        }

        if (isNegative) {
            result = 1.0 / result;
        }

        return result; 
    }
    public boolean equals(double num1, double num2) {
        if (Math.abs(num1 - num2) < 0.00000001) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.power(-2, -11));
    }
}