class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < Math.ceil(n / 2.0); i++) {
            ratoteOneFloor(matrix, i);
        }
    }

    public void ratoteOneFloor(int[][] matrix, int n) {
        int[] temp = new int[matrix.length - n - n - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = matrix[n][i + n + 1];
        }
//        System.out.println(Arrays.toString(temp));
        for (int i = 0; i < temp.length; i++) {
            matrix[n][matrix.length - n - i - 1] = matrix[i + n][n];
        }
        for (int i = 0; i < temp.length; i++) {
            matrix[i + n][n] = matrix[temp.length + n][i + n];
        }
        for (int i = 0; i < temp.length; i++) {
            matrix[temp.length + n][i + n] = matrix[ temp.length + n - i][temp.length + n];
        }
        for (int i = 0; i < temp.length; i++) {
            matrix[i + n + 1][temp.length + n] = temp[i];
        }

    }

    public void justPrint(int[][] matrix) {
        for (int i = 0; i< matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7},
                {4, 5, 6, 3, 1, 2},
                {7, 8, 9, 4, 2, 1},
                {2, 31, 2, 3, 5, 2},
                {21, 32, 43, 54, 21, 21}
        };
        Solution solution = new Solution();
        solution.rotate(matrix);
    }

}