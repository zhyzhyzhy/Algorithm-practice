public class Solution {

    public static void main(String[] args) {
        
    }
    public int[][] imageSmoother(int[][] M) {
        int count = 0;
        int[][] result = new int[M.length][M[0].length];
        int sum = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                
                for (int m = i - 1; m <= i + 1; m++) {
                    for (int n = j - 1; n <= j+1; n++) {
                        if (n < 0 || m < 0 || m > M.length - 1 || n > M[0].length - 1) {
                            continue;
                        }
                        count++;
                        sum += M[m][n];
                    }
                }
                
                result[i][j] = sum / count;
                count = 0;
                sum = 0;
            }
        }
        return result;
    }

}