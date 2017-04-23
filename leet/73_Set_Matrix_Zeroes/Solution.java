//两个set
import java.util.HashSet;
import java.util.Set;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/04/23 - 13:24:05
*/
public class Solution{
	public static void main(String[] args) {

	}
    public void setZeroes(int[][] matrix) {
		Set<Integer> row    = new HashSet<>();
		Set<Integer> column = new HashSet<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					row.add(i);
					column.add(j);
				}
			}
		}
		for (Integer i : row) {
			for (int j = 0; j < matrix[i].length;j++ ) {
				matrix[i][j] = 0;
			}
		}
		for (Integer i : column) {
			for (int j = 0; j < matrix.length;j++ ) {
				matrix[j][i] = 0;
			}
		}
    }
}
