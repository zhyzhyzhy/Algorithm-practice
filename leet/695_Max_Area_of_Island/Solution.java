/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/15 - 15:42:29
*/
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = areaOfOnePoint(grid, i, j);
                    max = max > area ? max : area;
                }
            }
        }
        return max;
    }
    public int areaOfOnePoint(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return 0;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + areaOfOnePoint(grid, i - 1, j) + areaOfOnePoint(grid, i + 1, j) + areaOfOnePoint(grid, i, j - 1) + + areaOfOnePoint(grid, i, j + 1);
        }
        else {
            return 0;
        }
    }

}
