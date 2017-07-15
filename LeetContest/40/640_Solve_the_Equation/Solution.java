/**
 * Created by zhuyichen on 2017/7/9.
 */
public class Solution {
    public String solveEquation(String equation) {
        int index = equation.indexOf('=');
        if (equation.charAt(index+1) == '+' || equation.charAt(index + 1) == '-') {
            equation = equation.substring(0,index) + equation.substring(index + 1);
        } else {
            equation = equation.replace('=', '+');
        }
        char[] equ = equation.toCharArray();
        for (int i = index; i < equ.length; i++) {
            if (equ[i] == '+') {
                equ[i] = '-';
            } else if (equ[i] == '-') {
                equ[i] = '+';
            }
        }
        if (equ[0] == '-' || equ[0] == '+') {
            equation = String.valueOf(equ) + "+";
        }
        else {
            equation = "+" + String.valueOf(equ) + "+";
        }
        equ = equation.toCharArray();
        String left = null;
        String right = null;
        int leftSum = 0;
        int rightSum = 0;
//        System.out.println(equation);
        for (int i = 1; i < equation.length(); i++) {
            if (equ[i] == '+' || equ[i] == '-') {
                int j = i - 2;
                while (equ[j] != '-' && equ[j] != '+') {
                    j--;
                }

                if (equ[i-1] == 'x') {
                    if (j + 1 == i -1) {
                        if (equ[j] == '+')
                            leftSum += 1;
                        else
                            leftSum -= 1;
                    }
                    else {
                        if (equ[j] == '+')
                            leftSum += Integer.parseInt(equation.substring(j+1, i-1));
                        else
                            leftSum -= Integer.parseInt(equation.substring(j+1, i-1));
                    }
                }
                else {
                    if (equ[j] == '+' )
                        rightSum += Integer.parseInt(equation.substring(j+1,i));
                    else
                        rightSum -= Integer.parseInt(equation.substring(j+1,i));
                }
            }
        }
//        System.out.println(leftSum + "  " + rightSum);


        if (rightSum == 0 && leftSum == 0) {
            return "Infinite solutions";
        }
        if (leftSum == 0) {
            return "No solution";
        }
        rightSum = 0 - rightSum / leftSum;
        return "x=" + rightSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveEquation("2x+3x-6x=x+2"));
    }
}
