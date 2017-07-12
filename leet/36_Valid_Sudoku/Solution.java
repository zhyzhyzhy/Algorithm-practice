import java.util.HashSet;
import java.util.Set;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
       Set<Character> set = new HashSet<>();
       for (int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[i].length; j++) {
               if (board[i][j] != '.') {
                    if (!set.add(board[i][j])) {
                        return false;
                    }
               }
           }
           set.clear();
           for (int j = 0; j < board[i].length; j++) {
               if (board[j][i] != '.') {
                    if (!set.add(board[j][i])) {
                        return false;
                    }
               }
           }
           set.clear();
       }
       for (int i = 0; i < board.length - 2; i = i + 3) {
           for (int j = 0; j < board.length - 2; j = j + 3) {
              for (int m = i; m < i + 3; m++) {
                  for (int n = j; n < j + 3; n++) {
                       if (board[m][n] != '.') {
                            if (!set.add(board[m][n])) {
                                return false;
                            }
                        } 
                  }
              } 
             set.clear();
           }
       }
       return true;
    }
    public static void main(String[] args) {
        
    }
}