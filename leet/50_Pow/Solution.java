/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/11/16 - 19:50:15
*/
class Solution {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            x = Math.abs(x);
            if (x < 1.000001 )
                return 1.00000;
            else
                return 0.00000;
        }
        boolean negative = false;
        if (n < 0) {
            n = -n;
            negative = true;
        }

        double result = getResult(x, n);
        if (negative) {
            return 1.0 / result;
        }
        return result;
    }
    public double getResult(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double result = getResult(x, n >> 1);
        if (n % 2 == 1) {
            return result *= result * x;
        }
        else {
            return result * result;
        }

    }
}
