import java.util.ArrayList;
import java.util.List;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/07/19 - 10:30:54
*/
public class Solution{
	public static void main(String[] args) {

	}
		private List<Integer> list = new ArrayList<>();
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0) {
			return list;
		}
		addNumber(matrix, 0, 0);
		return list;
    }
	public void addNumber(int[][] matrix, int i, int j) {
		int row = matrix.length;
		int columns = matrix[0].length;
		if (i * 2 >= row || 2 * j >= columns) {
			return;
		}
		if (i == row - i - 1) {
			for (int startcol = j; startcol < columns -j; startcol++) {
				list.add(matrix[i][startcol]);
			}
		}
		else if (j == columns - j - 1) {
			for (int startrow = i; startrow < row - i; startrow++) {
				list.add(matrix[startrow][j]);
			}

		}
		else {
			for (int startcol = j; startcol < columns - j; startcol++) {
				list.add(matrix[i][startcol]);
			}
			for (int startrow = i + 1; startrow < row - i; startrow++) {
				list.add(matrix[startrow][columns - j - 1]);
			}
			for (int startcol = columns - j - 2; startcol >= j; startcol--) {
				list.add(matrix[row - i - 1][startcol]);
			}
			for (int startrow = row - i - 2; startrow > i; startrow--) {
				list.add(matrix[startrow][j]);
			}
			addNumber(matrix, i + 1, j + 1);
		}
	}
}

