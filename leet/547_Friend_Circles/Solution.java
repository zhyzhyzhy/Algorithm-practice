
public class Solution {
    public static int findCircleNum(int[][] M) {
        int length = M.length;
        boolean[] isConn = new boolean[length];
        int count  = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (M[i][j] == 1 && isConn[j] == false) {
                    dfs(M, isConn, j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int[][] M, boolean[] isConn, int i) {
        if (isConn[i] == true) {
            return;
        }
        else {
            isConn[i] = true;
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && isConn[j] == false) {
                    dfs(M, isConn, j);
                }
            }
        }

    }
    public static void main(String[] args) {
       int[][] M = {
           {1,1,0},
            {1,1,1},
            {0,1,1}
       };
       System.out.println(findCircleNum(M));
    }
}