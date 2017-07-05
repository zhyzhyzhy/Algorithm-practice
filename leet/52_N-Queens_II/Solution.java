import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        int[] matrix = new int[n];
        for (int i = 0; i < n; i++) {
            matrix[0] = i;
            forSolve(matrix, n, 1);
        }    
        return count;    
    }
    public void forSolve(int[] matrix, int n, int i) {
        if (i == n) {
           count++;
        }
        else {
            int j = 0;
            for (j = 0; j < n; j++) {
                int k = 0;
                for ( k = 0; k < i; k++) {
                    if (Math.abs(matrix[k] - j) == Math.abs(i - k) || j == matrix[k]) {
                        break;
                    }
                }
                if (k == i) {
                    matrix[i] = j;
                    forSolve(matrix, n, i + 1);
                }
            }
        }
    }
    public static void main(String[] args) {
       Solution solution = new Solution();
       System.out.println(solution.solveNQueens(4)); 
    }
}